from os import environ
from flask import Flask, url_for, request, render_template, make_response, session, g
from werkzeug.contrib.fixers import LighttpdCGIRootFix
from werkzeug.utils import secure_filename, redirect

__author__ = 'patrick'

app = Flask(__name__)


@app.route("/")
def hello_world():
    resp = make_response(username='username')
    resp.set_cookie('username', 'this is test')
    return "Hello World"


@app.route("/index")
@app.route('/index/<name>')
def index(name=None):
    return render_template('index.html', name=name)


# variable Rules
@app.route('/user/<key>')
def show_key(key):
    return 'Key %s' % key


# int	accepts integers
# float	like int but for floating point values
# path	like the default but also accepts slashes

@app.route('/post/<int:id>')
def show_post(id):
    return 'post_id:%d' % id


# slight different between slash as last character

# both curl /projects/ or curl /project to the same page
# GET
# The browser tells the server to just get the information stored on that page and send it. This is probably the most common method.
# HEAD
# The browser tells the server to get the information, but it is only interested in the headers, not the content of the page. An application is supposed to handle that as if a GET request was received but to not deliver the actual content. In Flask you don’t have to deal with that at all, the underlying Werkzeug library handles that for you.
# POST
# The browser tells the server that it wants to post some new information to that URL and that the server must ensure the data is stored and only stored once. This is how HTML forms usually transmit data to the server.
# PUT
# Similar to POST but the server might trigger the store procedure multiple times by overwriting the old values more than once. Now you might be asking why this is useful, but there are some good reasons to do it this way. Consider that the connection is lost during transmission: in this situation a system between the browser and the server might receive the request safely a second time without breaking things. With POST that would not be possible because it must only be triggered once.
# DELETE
# Remove the information at the given location.
# OPTIONS
# Provides a quick way for a client to figure out which methods are supported by this URL. Starting with Flask 0.6, this is implemented for you automatically.

@app.route('/projects/', methods=['GET', 'POST'])
def projects():
    if request.method == 'POST':
        return "this post page"
    elif request.method == 'GET':
        return "this is get page"
    else:
        return 'The project page'


# curl /about/ getting 404 not found
@app.route('/about')
def about():
    return 'The about page'


# URL Building
with app.test_request_context():
    print(url_for('index'))
    print(url_for('about'))
    print(url_for('projects'))
    print(url_for('show_post', id=1234))


# static files
# To generate URLs for static files, use the special 'static' endpoint name:

# request object/data
with app.test_request_context('/projects/', 'GET'):
    assert request.path == '/projects/'
    assert request.method == 'GET'


# with app.request_context(environ):
#     assert request.method == 'POST'


# using request
def validate_login(username, password):
    return False


@app.route('/login', methods=['POST', 'GET'])
def login():
    err = None
    if request.method == 'POST':
        if validate_login(request.form['username'], request.form['password']):
            return "Success"
        else:
            error = "Invalid Password/username"
    return render_template('index.html', error=error)


# getting query parameters
@app.route('/query')
def search():
    kw = request.args.get('q')
    return kw
    try:
        print(test)
    except KeyError:
        print("test")


# file upload
@app.route('/upload', methods=['GET', 'POST'])
def upload_file():
    f = request.files['file']
    f.save('files' + secure_filename(f.filename))


# cookie
@app.route('/cookie')
def cookie():
    username = request.cookies.get('username')
    cookie_1 = request.cookies.get('username')
    return str(username) + str(cookie_1)


# error handle
@app.errorhandler(404)
def page_not_found(error):
    return render_template('page_not_found.html'), 404


# sessions
@app.route('/logout')
def logout():
    print(request.args)
    session.pop('username', None)
    app.logger.info("this is logout")
    return redirect(url_for('index'))

# statement

ctx=app.app_context()
ctx.push()
g.foo=42
print(g.foo)

ctx=app.test_request_context()
ctx.push()
print(request.url)
print(request.args)


# hooking in werkzeug package
app.wsgi_app = LighttpdCGIRootFix(app.wsgi_app)
app.secret_key = 'testestestestetes'

if __name__ == '__main__':
    app.run(debug=True)
