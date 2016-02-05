from flask.ext.sqlalchemy import SQLAlchemy

db = SQLAlchemy()


class CRUD_MixIn():

    creation_time = db.Column(
            db.TIMESTAMP, server_default=db.func.current_timestamp(), nullable=False)
    modification_time = db.Column(
            db.TIMESTAMP, server_default=db.func.current_timestamp(), nullable=False)

    def add(self, resource):
        db.session.add(resource)
        db.session.commit()
        return resource

    def update(self):
        db.session.commit()
        return self

    def delete(self, resource):
        db.session.delete(resource)
        db.session.commit()
        return resource
