from flask import Flask, jsonify

__author__ = 'patrick'


class CustomFlask(Flask):
    def make_response(self, rv):
        if hasattr(rv, 'tojson'):
            return jsonify(rv.tojson())
        return Flask.make_response(self, rv)


class User(object):
    def __init__(self, id, username):
        self.id = id
        self.username = username

    def tojson(self):
        return {
            'id': self.id,
            'username': self.username
        }


app = CustomFlask(__name__)


@app.route("/")
def index():
    return User(43, 'patrick')

if __name__ == '__main__':
    app.run(debug=True)
