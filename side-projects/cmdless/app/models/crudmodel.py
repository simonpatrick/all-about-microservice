from ._base import db


class CRUDMixIn():
    def add(self, data):
        db.session.add(data)
        return db.session.commit()

    def delete(self):
        self.setValue('status', '0')
        return db.session.commit()

    def update(self):
        return db.session.commit()
