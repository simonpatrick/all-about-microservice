__author__ = 'patrick'


class User(object):
    def __init__(self, user_id, user_name):
        self.user_id = user_id
        self.user_name = user_name

    def to_s(self):
        return "{0},{1}".format(self.user_id, self.user_name)
