from angular_sample.server.app.server import db
from passlib.apps import custom_app_context as pwd_context

__author__ = 'patrick'


class User(db.Model):
    __tablename__ = 'users'
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(32), index=True)
    password_hash = db.Column(db.String(128))

    def hash_password(self,password):
        self.password_hash = pwd_context.encrypt(password)

    def verify_password(self,password):
        return pwd_context.verify(password,self.password_hash)