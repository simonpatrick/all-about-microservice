from flask import request, jsonify
from flask.ext.restful import Resource


class BaseResource(Resource):
    # staticmethod
    def get_valid_request_data(self, schema):
        raw_dict = request.get_json(force=True)
        schema.validate(raw_dict)
        request_dict = raw_dict['data']['attributes']
        return request_dict

    def make_401_response(self, message=None):

        if message is None:
            response = jsonify(message='Token is invalid')
        else:
            response = jsonify(message='message')
        response.status_code = 401
        return response

    def make_403_response(self, message=None):
        if message is None:
            message = "Unknown error happened"
        resp = jsonify({"error": message})
        resp.status_code = 403
        return resp
