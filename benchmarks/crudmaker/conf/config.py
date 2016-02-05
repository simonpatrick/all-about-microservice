# pg DB Setting
pg_db_username = 'tester'
pg_db_password = ''
pg_db_name = 'CI'
pg_db_hostname = 'localhost:5432'

# MYSQL
mysql_db_username = 'tester'
mysql_db_password = ''
mysql_db_name = 'CI'
mysql_db_hostname = 'localhost'

# Flask Configuration

DEBUG = True
PORT = 5000
HOST = "0.0.0.0"
SQLALCHEMY_ECHO = False
SECRET_KEY = "TESTER"
SQLALCHEMY_TRACK_MODIFICATIONS = False

# PostgreSQL
SQLALCHEMY_DATABASE_URI = \
    "postgresql://{DB_USER}:{DB_PASS}@{DB_ADDR}/{DB_NAME}" \
        .format(DB_USER=pg_db_username,
                DB_PASS=pg_db_password,
                DB_ADDR=pg_db_hostname,
                DB_NAME=pg_db_name)

# MySQL
"""
SQLALCHEMY_DATABASE_URI = "mysql+pymysql://{DB_USER}:{DB_PASS}@{DB_ADDR}/{DB_NAME}"
.format(DB_USER=mysql_db_username,
        DB_PASS=mysql_db_password,
        DB_ADDR=mysql_db_hostname,
        DB_NAME=mysql_db_name)
"""

MAIL_DEFAULT_SENDER = "localhost@localhost"

PASSWORD_RESET_EMAIL = """
    Hi,

      Please click on the link below to reset your password

      <a href="/forgotpassword/{token}> Click here </a>"""
