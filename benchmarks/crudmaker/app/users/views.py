from app.basemodels import db
from app.baseresource import BaseResource
from app.users.models import UsersSchema, Users
from flask import Blueprint, make_response, jsonify
from flask.ext.restful import Api, Resource
from marshmallow import ValidationError
from sqlalchemy.exc import SQLAlchemyError
from werkzeug.security import generate_password_hash

users = Blueprint('users', __name__)
api = Api(users)
schema = UsersSchema(strict=True)


class UsersResource(BaseResource):
    """http://jsonapi.org/format/#fetching
     A server MUST respond to a successful request to fetch an individual resource or resource collection with a 200 OK response.
     A server MUST respond with 404 Not Found when processing a request to fetch a single resource that does not exist, except when the request warrants a 200 OK response with null as the primary data (as described above)
     a self link as part of the top-level links object
     """

    def get(self):
        users_query = Users.query.all()
        results = schema.dump(users_query, many=True).data
        return results

    def post(self):
        try:
            request_dict = self.get_valid_request_data(schema)
            user = Users(request_dict['email'],
                         generate_password_hash(request_dict['password']),
                         request_dict['name'],
                         request_dict['active'],
                         request_dict['role'])
            user = user.add(user)
            results = schema.dump(user).data
            return results, 201

        except ValidationError as validation_error:
            return self.make_403_response(validation_error.messages)
        except SQLAlchemyError as sql_error:
            db.session.rollback()
            return self.make_403_response(sql_error.messages)


class UserResource(BaseResource):
    """http://jsonapi.org/format/#fetching
    A server MUST respond to a successful request to fetch an individual resource or resource collection with a 200 OK response.
    A server MUST respond with 404 Not Found when processing a request to fetch a single resource that does not exist, except when the request warrants a 200 OK response with null as the primary data (as described above)
    a self link as part of the top-level links object"""

    def get(self, id):
        user_query = Users.query.get_or_404(id)
        result = schema.dump(user_query).data
        return result, 200

    """http://jsonapi.org/format/#crud-updating"""
    def patch(self, id):
        user = Users.query.get_or_404(id)
        try:
            request_dict = self.get_valid_request_data(schema)
            for key, value in request_dict.items():
                setattr(user, key, value)
            user.update()
            return self.get(id)
        except ValidationError as validation_error:
            return self.make_403_response(validation_error.messages)
        except SQLAlchemyError as sql_error:
            db.session.rollback()
            return self.make_403_response(sql_error.messages)

    def delete(self, id):
        user = Users.query.get_or_404(id)
        try:
            delete = user.delete(user)
            response = make_response()
            response.status_code = 204
            return response

        except SQLAlchemyError as sql_error:
            db.session.rollback()
            return self.make_403_response(sql_error.messages)


api.add_resource(UsersResource, '')
api.add_resource(UserResource, '/<int:id>')
