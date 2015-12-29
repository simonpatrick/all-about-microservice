import os
from angular_sample.server.app.helloworld import HelloWorld
from angular_sample.server.app.resources import userapi
from angular_sample.server.app.resources import taskapi
from angular_sample.server.app.resources import taskListAPI
from flask import Flask
from flask_restful import Api

__author__ = 'patrick'

basedir = os.path.join(os.path.abspath(os.path.dirname(__file__)), '../')

app = Flask(__name__)
# app.config.from_object('app.config')

# # flask-sqlalchemy
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + os.path.join(basedir, 'app.sqlite')
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

# flask-resful
api = Api(app)

api.add_resource(HelloWorld, '/')
api.add_resource(userapi.UserAPI, '/users/<int:id>', endpoint='user')
api.add_resource(taskapi.TaskAPI, '/tasks/<int:id>', endpoint='task')
api.add_resource(taskListAPI.TaskListAPI, '/tasks', endpoint='tasks')

if __name__ == '__main__':
    app.run(debug=True)
