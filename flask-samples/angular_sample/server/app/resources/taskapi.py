from flask.ext.restful import Resource, reqparse, abort

__author__ = 'patrick'


class TaskAPI(Resource):
    def __init__(self):
        self.req_parse = reqparse.RequestParser()
        self.req_parse.add_argument('title', type=str, location='json')
        self.req_parse.add_argument('description', type=str, location='json')
        self.req_parse.add_argument('done', type=bool, location='json')
        super(TaskAPI, self).__init__()

    def get(self, id):
        pass

    def put(self, id):
        tasks = []
        task = filter(lambda t: t['id'] == id, tasks)
        if len(task) == 0:
            abort(400)
        task = task[0]
        args = self.req_parse.parse_args()
        for k, v in args.items():
            if v is not None:
                task[k] = v
        return {'task': task}, 200

    def delete(self, id):
        pass
