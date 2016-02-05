from datetime import datetime, timedelta
from email.message import Message
from functools import wraps

import flask_restful
import jwt
from crudmaker.app.basemodels import db
from jwt import DecodeError, ExpiredSignature
from app.users.models import UsersSchema, Users
from conf.config import SECRET_KEY, PASSWORD_RESET_EMAIL
from flask import Blueprint, request, jsonify, g, make_response
from flask.ext.restful import Api, Resource
from marshmallow import schema, ValidationError
from sqlalchemy.exc import SQLAlchemyError
from werkzeug.security import check_password_hash, generate_password_hash

login1 = Blueprint('login', __name__)
api = Api(login1)

users_schema = UsersSchema(strict=True)


def create_token(user):
    payload = {
        'sub': user.id,
        'iat': datetime.utcnow(),
        'exp': datetime.utcnow() + timedelta(days=1),
        'scope': user.role
    }

    token = jwt.encode(payload, SECRET_KEY)
    return token.decode('unicode_escape')


def parse_token(req):
    token = req.headers.get('Authorization').split()[1]
    return jwt.decode(token, SECRET_KEY, algorithms='HS256')


def make_missing_authorization():
    response = jsonify(message='Missing authorization header')
    response.status_code = 401
    return response


def make_401_response(message=None):
    if message is None:
        response = jsonify(message='Token is invalid')
    else:
        response = jsonify(message='message')
    response.status_code = 401
    return response


def make_403_response(message):
    resp = jsonify({"error": message})
    resp.status_code = 403
    return resp


# login decorator function
def login_required(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        if not request.headers.get('Authorization'):
            return make_missing_authorization()
        try:
            payload = parse_token(request)
        except DecodeError:
            return make_401_response()
        except ExpiredSignature:
            return make_401_response('Token has expired')

        g.user_id = payload['sub']
        return f(*args, **kwargs)

    return decorated_function


# Admin login required
def admin_login_required(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        if not request.headers.get('Authorization'):
            return make_missing_authorization()

        try:
            # print(request.headers.get('Authorization'))
            payload = parse_token(request)
            if payload['scope'] != "admin":
                response = jsonify(error='Admin Access Required')
                response.status_code = 401
                return response
        except DecodeError:
            return make_401_response()
        except ExpiredSignature:
            return make_401_response('Token has expired')

        g.user_id = payload['sub']

        return f(*args, **kwargs)

    return decorated_function


class Auth(Resource):
    def post(self):
        raw_request = request.get_json(force=True)
        data = raw_request['data']['attributes']
        email = data['email']
        password = data['password']
        user = Users.query.filter_by(email=email).first()
        if user is None:
            response = make_response(
                    jsonify({"message": "invalid username/password"})
            )
            response.status_code = 401
            return response
        if check_password_hash(user.password, password):
            token = create_token(user)
            return {'token': token}
        else:
            response = make_response(jsonify({"message": "invalid username/password"}))
            response.status_code = 401
            return response


# api.add_resource(Auth, '/login')


class SignUp(Resource):
    def post(self):
        raw_request = request.get_json(force=True)
        try:
            schema.validate(raw_request)
            request_dict = raw_request['data']['attributes']
            role = None
            active = "false"
            user = Users(request_dict['email'], generate_password_hash(request_dict['password']), request_dict['name'],
                         active,
                         role)
            user.add(user)
            # Should not return password hash
            query = Users.query.get(user.id)
            results = schema.dump(query).data
            return results, 201
        except ValidationError as validateError:
            return make_403_response(validateError.messages)
        except SQLAlchemyError as sqlError:
            db.sesson.rollback()
            return make_403_response(str(sqlError))


# api.add_resource(SignUp, '/signup')
class ForgotPassword(Resource):
    def patch(self):
        if not request.headers.get('Authorization'):
            response = jsonify(message='Missing authorization header')
            response.status_code = 401
            return response

        try:
            print(request.headers.get('Authorization'))
            payload = parse_token(request)
            user_id = payload['sub']
            user = Users.query.get_or_404(user_id)
            print(request.data)
            raw_dict = request.get_json(force=True)
            request_dict = raw_dict['data']['attributes']

            user.password = generate_password_hash(request_dict['password'])
            try:
                user.update()
                return 201

            except SQLAlchemyError as e:
                db.session.rollback()
                resp = jsonify({"error": str(e)})
                resp.status_code = 401
                return resp
        except DecodeError:
            response = jsonify(message='Token is invalid')
            response.status_code = 401
            return response
        except ExpiredSignature:
            response = jsonify(message='Token has expired')
            response.status_code = 401
            return response

    def post(self):
        request_dict = request.get_json(force=True)['data']['attributes']
        email = request_dict['email']
        user = Users.query.filter_by(email=email).first()
        if user is not None:
            token = create_token(user)
            msg = Message("Here's your Password Reset Link :)",
                          recipients=[email])
            msg.html = PASSWORD_RESET_EMAIL.format(token=token)
            # mail.send(msg)
            return {"message": "Password reset mail sent successfully"}, 201
        else:
            return {"error": "We could not find this email address :("}, 404


# api.add_resource(ForgotPassword, '/forgotpassword')

# class Resource(flask_restful.Resource):
#     method_decorators = [login_required]
