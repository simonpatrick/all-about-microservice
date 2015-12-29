from datetime import datetime
from ops.ops import db

__author__ = 'patrick'


class Base(db.Model):
    id = db.Column(db.INTEGER, primary_key=True)
    created_by = db.Column(db.String(20))
    created_date = db.Column(db.DateTime)
    last_updated_by = db.Column(db.String(20))
    last_update_date = db.Column(db.DateTime)

    def __init__(self):
        pass

    def update(self, user_name):
        self.last_update_date = datetime.date()
        self.last_updated_by = user_name

    def new(self, user_name):
        self.created_date = datetime.date()
        self.last_update_date = datetime.date()
        self.created_by = user_name
        self.last_updated_by = user_name
