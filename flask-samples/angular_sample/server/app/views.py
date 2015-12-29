from angular_sample.server.app.forms import UserCreateForm, SessionCreateForm, PostCreateForm
from angular_sample.server.app.models.models import User, Post
from angular_sample.server.app.serializers import UserSerializer, PostSerializer
from angular_sample.server.app.server import auth, db, api
from flask import g
from flask.ext.restful import Resource


@auth.verify_password
def verify_password(email, password):
    user = User.query.filter_by(email=email).first()
    if not user:
        return False
    g.user = user
    return user.verify_password(password)


class UserView(Resource):
    def post(self):
        form = UserCreateForm()
        if not form.validate_on_submit():
            return form.errors, 422

        user = User(form.email.data, form.password.data)
        db.session.add(user)
        db.session.commit()
        return UserSerializer(user).data


class SessionView(Resource):
    def post(self):
        form = SessionCreateForm()
        if not form.validate_on_submit():
            return form.errors, 422

        user = User.query.filter_by(email=form.email.data).first()
        if user and user.verify_password(form.email.password):
            return UserSerializer(user).data, 201
        return '', 401


class PostListView(Resource):
    def get(self):
        posts = Post.query.all()
        return PostSerializer(posts, many=True).data

    @auth.login_required
    def post(self):
        form = PostCreateForm()
        if not form.validate_on_submit():
            return form.errors, 422
        post = Post(form.title.data, form.body.data)
        db.session.add(post)
        db.session.commit()
        return PostSerializer(post).data, 201


class PostView(Resource):
    def get(self, id):
        posts = Post.query.filter_by(id=id).first()
        return PostSerializer(posts).data


api.add_resource(UserView, '/api/v1/users')
api.add_resource(SessionView, '/api/v1/sessions')
api.add_resource(PostListView, '/api/v1/posts')
api.add_resource(PostView, '/api/v1/posts/<int:id>')
