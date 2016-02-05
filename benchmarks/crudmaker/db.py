from flask.ext.migrate import Migrate, MigrateCommand
from flask.ext.script import Manager

from app import db
from crudmaker import crud_maker

crud_maker.config.from_object('conf.config')

migrate = Migrate(crud_maker, db)
manager = Manager(crud_maker)
manager.add_command('db', MigrateCommand)


if __name__ == '__main__':
    manager.run()