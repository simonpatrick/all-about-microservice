from ops.models import base
from ops.ops import db

__author__ = 'patrick'

class AssertCategory(base.Base):
    id = db.Column(db.INTEGER,primary_key=True)
    asset_category_description= db.Column(db.String(80))
    asset_category_status=db.Column(db.Boolean)

    def __init__(self,asset_category_description,asset_category_status,created_by):
        self.asset_category_description=asset_category_description
        self.asset_category_status=asset_category_status
        self.new(created_by)

    def __repr__(self):
        return 'AssertCategory %s' % self.asset_category_description