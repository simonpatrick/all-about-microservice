from app.basemodels import db
from flask import Flask, render_template

from app.users.views import users


def create_app(config_file_name):
    app = Flask(__name__)
    app.config.from_object(config_file_name)

    # init db
    db.init_app(app)
    # user users api
    app.register_blueprint(users, url_prefix='/api/v1/users')

    # ignore login first

    @app.route('/')
    def index():
        return render_template('index.html')

    return app
