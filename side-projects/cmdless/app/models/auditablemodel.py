import datetime

from ._base import db


class AuditableModel(db.Model):
    created_at = db.Column(db.DateTime, default=datetime.now)
    created_by = db.Column(db.String(200))
    modified_at = db.Column(db.DateTime, default=datetime.now)
    modified_by = db.Column(db.String(200))
    status = db.Column(db.Integer, default=1)
