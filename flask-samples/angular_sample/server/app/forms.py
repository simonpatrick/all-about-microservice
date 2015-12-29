from angular_sample.server.app.models.models import User, Post
from angular_sample.server.app.server import db
from flask.ext.wtf import Form
from wtforms import StringField
from wtforms.validators import DataRequired
from wtforms_alchemy import model_form_factory

__author__ = 'patrick'

BaseModelForm = model_form_factory(Form)


class ModelForm(BaseModelForm):
    @classmethod
    def get_session(self):
        return db.session


class UserCreateForm(ModelForm):
    class Meta:
        model = User


class SessionCreateForm(Form):
    email = StringField('name', validators=[DataRequired()])
    password = StringField('password', validators=[DataRequired()])


class PostCreateForm(ModelForm):
    class Meta:
        model = Post
