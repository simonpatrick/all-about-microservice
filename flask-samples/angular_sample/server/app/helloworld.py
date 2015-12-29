from flask.ext.restful import Resource

__author__ = 'patrick'


class HelloWorld(Resource):
    def get(self):
        return {"hello": "world"}
