import os

basedir = os.path.join(os.path.abspath(os.path.dirname(__file__)))

# global configuration
# /config.py
# /run.py
# /shell.py
# /app.db
# /app/__init__.py
# /app/constants.py
# /app/static/
global_files = {
    "config": "config.py",
    "run": "run.py",
    "shell": "shell.py",
    "db": "app.db"
}


def create_project_file(path, files_config):
    if not os.path.exists(path):
        os.mkdir(path)
    print(path)
    for k in files_config:
        if str(files_config[k]).find(".")==0:
            os.mkdir(path+"/"+files_config[k])

        with open(path+"/"+files_config[k],'a+') as f:
            f.close()
        print(files_config[k])


app_file = {
    "init": "__init__.py",
    "constants": "constants.py",
    "static": "static"
}

# /app/users/__init__.py
# /app/users/views.py
# /app/users/forms.py
# /app/users/constants.py
# /app/users/models.py
# /app/users/decorators.py

module_files = {
    "init": "__init__.py",
    "constants": "constants.py",
    "decorator": "decorators.py",
    "forms": "forms.py",
    "models": "models.py",
    "views": "views.py"
}

if __name__ == '__main__':
    print(basedir)
    create_project_file(basedir, global_files)
    create_project_file(basedir+"/app", app_file)
