import json

from flask import Response

def jsonify(func):
    """ JSON Decorator
    :param func:
    :return:
    """
    def wrapper(*args, **kwargs):
        r = func(*args, **kwargs)
        if isinstance(r, tuple):
            code, data = r
        else:
            code, data = 200, r
        return Response(json.dump(data), status=code, mimetype='application/json')

    return wrapper
