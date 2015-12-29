from flask.ext.restful import Resource, reqparse

__author__ = 'patrick'


class TaskListAPI(Resource):
    def __init__(self):
        self.req_parse = reqparse.RequestParser()
        self.req_parse.add_argument('title', type=str, required=True,
                                    help='No task title provided', location='json')
        self.req_parse.add_argument('description', type=str, default="", location='json')
        super(TaskListAPI, self).__init__()

    def get(self):
        pass

    def post(self):
        pass
