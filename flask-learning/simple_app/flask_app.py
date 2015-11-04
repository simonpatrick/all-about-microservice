from flask import Flask, request, url_for

__author__ = 'patrick'

app = Flask(__name__)


@app.route('/')
def hello_world():
    return "Hello World!"


@app.route('/user')
def hello_user():
    return "Hello User"


@app.route('/user/<user_id>')
def get_user_by_id(user_id):
    return "hello user: " + user_id


@app.route('/query_user')
def query_user():
    user_id = request.args.get('id')
    return "user_id: {0}".format(user_id)


@app.route('/query_url')
def query_url():
    return 'query url:' + url_for('/query_user')


if __name__ == '__main__':
    app.run(debug=True)
