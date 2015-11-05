import base64
import random
import time
from flask import Flask, render_template, request
from flask.json import dump
from simple_app.models.user import User

__author__ = 'patrick'

t_app = Flask(__name__)


@t_app.route('/')
def hello_world():
    content = "Hello World Man!"
    return render_template("index.html", content=content)


@t_app.route('/user')
def user_index():
    user = User(1, 'test_user')
    return render_template("user_index.html", user=user)


@t_app.route('/user/<user_id>')
def query_user(user_id):
    user = None
    if int(user_id) == 1:
        user = User(1, 'test_user')
    return render_template("user.html", user=user)


@t_app.route('/users')
def list_users():
    users = []
    for i in range(1, 11):
        user = User(i, "test_user" + str(i))
        users.append(user)
    return render_template("users.html", users=users)


@t_app.route('/one')
def user_template_based_on_base():
    return render_template('one.html')


@t_app.route('/two')
def user_template_two():
    return render_template('two.html')


user_tokens = {
    "patrick": ["1234567"]
}


# token
@t_app.route('/get_token/<uid>')
def get_token(uid):
    print(uid)
    print(user_tokens[uid])
    print(str(uid))
    print(str(random.random()))
    print(str(time.time()+7200))
    result=':'.join([str(uid), str(random.random()), str(time.time())])
    print(result)
    token = base64.b64encode(result.encode(encoding="utf-8"))
    user_tokens[uid].append(token)
    return token


def verify_token(token):
    if token is None:
        return -1
    _token = str(base64.b64decode(token))
    #_token =str(token)
    print(_token)
    print(_token.split(':')[0])
    if not user_tokens.get(_token.split(':')[0])[-1] == token:
        return -1
    if float(_token.split(':')[-1]) >= time.time():
        return 1
    else:
        return 0


@t_app.route('/test_token')
def test_token():
    print(request.headers)
    token = request.args.get('token')
    print(token)
    if verify_token(token) == 1:
        return 'data'
    else:
        return 'error'


if __name__ == '__main__':
    t_app.run(debug=True, port=5000)
