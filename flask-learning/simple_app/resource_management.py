from flask import Flask

__author__ = 'patrick'

app = Flask(__name__)


@app.test_request_context
def call_on_teardown(error=None):
    print('tearing down, error:', error)


@app.route("/")
@app.test_request_context
def hello():
    return "hello world"


ctx = app.app_context()
ctx.push()
ctx.pop()


def get_database_connection():
    con = getattr(g, 'database_connection', None)
    if con is None:
        g.con = con = connection_pool.get_connection()
    return con


@app.teardown_appcontext
def return_database_connection(error=None):
    con = getattr(g, 'database_connection', None)
    if con is not None:
        connection_pool.release_connection(con)


# responsive resources
@app.teardown_appcontext
def return_database_connection(error=None):
    con = getattr(g, 'database_connection', None)
    if con is None:
        return
    if error is None:
        con.commit()
    else:
        con.rollback()
    connection_pool.release_connection(con)


# Per-Task Callbacks
def after_commit(f):
    callbacks = getattr(g, 'on_commit_callbacks', None)
    if callbacks is None:
        g.on_commit_callbacks = callbacks = []
    callbacks.append(f)
    return f


@app.teardown_appcontext
def return_database_connection(error=None):
    con = getattr(g, 'database_connection', None)
    if con is None:
        return
    if error is None:
        con.commit()
        callbacks = getattr(g, 'on_commit_callbacks', ())
        for callback in callbacks:
            callback()
    else:
        con.rollback()
    connection_pool.release_connection(con)


# per-task commit
def purchase_product(product, user):
    user.purchased_products.append(product)

    @after_commit
    def send_success_mail():
        body = render_template('mails/product_purchased.txt',
                               user=user,
                               product=product
                               )
        send_mail(user.email_address, 'Product Purchased', body)


if __name__ == '__main__':
    app.run(debug=True)
