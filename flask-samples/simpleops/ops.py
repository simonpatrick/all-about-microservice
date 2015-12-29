from flask import Flask, render_template

__author__ = 'patrick'

ops_app = Flask(__name__)

HOST='0.0.0.0'
PORT='8888'

@ops_app.route('/')
def index():
    return render_template('index.html')


@ops_app.route('/addDNS')
def add_or_update_dns():
    return render_template('dns/editdns.html')

@ops_app.route('/dns')
def get_all_dns_setting():
    return render_template('dns/dns.html')

