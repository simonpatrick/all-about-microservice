from flask import Flask, make_response

__author__ = 'patrick'

config_app = Flask(__name__)


@config_app.route("/")
def index():
    return "welcome configuration page"

