import os


class Config(object):
    """Base Configuration Class"""
    DEBUG = True
    TESTING = False
    SECRET_KEY = "SECRET_KEY:TESTING"
    PERMANENT_SESSION_LIFETIME = 3600 * 24 * 7
    SESSION_COOKIE_NAME = '#{project}_session'

    # project path
    PROJECT_PATH = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))

    # Site domain
    SITE_TITLE = "#{project}"
    SITE_DOMAIN = "http://localhost:5000"

    # SQLAlchemy config
    # See:
    # https://pythonhosted.org/Flask-SQLAlchemy/config.html#connection-uri-format
    # http://docs.sqlalchemy.org/en/rel_0_9/core/engines.html#database-urls
    SQLALCHEMY_TRACK_MODIFICATIONS = False

    # Flask-DebugToolbar
    DEBUG_TB_INTERCEPT_REDIRECTS = False

    # Sentry config
    SENTRY_DSN = ''

    # Host string, used by fabric
    # HOST_STRING = "root@12.34.56.78"
    PORT = 5000
    HOST = "0.0.0.0"
    SQLALCHEMY_ECHO = False
    # DATABASE SETTINGS
    pg_db_username = 'tester'
    pg_db_password = ''
    pg_db_name = 'CI'
    pg_db_hostname = 'localhost:5432'
    # PostgreSQL
    SQLALCHEMY_DATABASE_URI = "postgresql://{DB_USER}:{DB_PASS}@{DB_ADDR}/{DB_NAME}" \
        .format(DB_USER=pg_db_username,
                DB_PASS=pg_db_password,
                DB_ADDR=pg_db_hostname,
                DB_NAME=pg_db_name)
    # MYSQL
    mysql_db_username = 'tester'
    mysql_db_password = ''
    mysql_db_name = 'CI'
    mysql_db_hostname = 'localhost:5432'

    # MySQL


# MySQL
"""SQLALCHEMY_DATABASE_URI = "mysql+pymysql://{DB_USER}:{DB_PASS}@{DB_ADDR}/{DB_NAME}".format(DB_USER=mysql_db_username,
                                                                                        DB_PASS=mysql_db_password,
                                                                                        DB_ADDR=mysql_db_hostname,
                                                                                        DB_NAME=mysql_db_name)"""
