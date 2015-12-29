from ops.ops import db

__author__ = 'patrick'

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True)
    email = db.Column(db.String(120), unique=True)

    def __init__(self, username, email):
        self.username = username
        self.email = email

    def __repr__(self):
        return '<User %r>' % self.username


if __name__ == '__main__':
    # db.create_all()
    # admin = User('admin', 'admin@example.com')
    # guest = User('guest', 'guest@example.com')
    # db.session.add(admin)
    # db.session.add(guest)
    # db.session.commit()
    users = User.query.all()
    admin = User.query.filter_by(username='admin').first()
    print(users)
    print(admin)