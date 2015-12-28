# __author__ = 'patrick'
#
# #!/usr/bin/env python
# #coding:utf-8
#
# 'this is a simple CMDB'
#
# #create mysql tabel
# '''
# create table `IP_list` (`ID` int(11) not null auto_increment  primary key, `IP` varchar(200) not null, `ClusterName` varchar(200) not null, `Server` varchar(200) not null, `Type`  varchar(200) not null, `Operator` varchar(200) not null, `Monitor` varchar(200) not null, `Contact` varchar(200) not null, `Status` varchar(200) not null ) ENGINE=MyISAM  DEFAULT CHARSET=utf8;
# '''
#
# import MySQLdb
# import json
# from flask import url_for,Flask,request,render_template,redirect,make_response,session
# app = Flask(__name__)
#
# class DB:
#   def __init__(self):
#     self.conn = MySQLdb.connect(
#                              user = 'hadp',
#                              passwd = 'hadoop',
#                              db = 'hadoop',charset='utf8')
#
#   def connect(self):
#     self.conn = MySQLdb.connect(
#                              user = 'hadp',
#                              passwd = 'hadoop',
#                              db = 'hadoop',charset='utf8')
#   def execute(self, sql):
#     try:
#       cursor = self.conn.cursor()
#       cursor.execute(sql)
#     except (AttributeError, MySQLdb.OperationalError):
#       self.connect()
#       cursor = self.conn.cursor()
#       cursor.execute(sql)
#     return cursor
#
#   def close(self):
#     if(self.cursor):
#       self.cursor.close()
#     self.conn.commit()
#     self.conn.close()
#
# db = DB()
# def str_html(allargs):
#     str = ''
#     for info in allargs:
#         s = '<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><span class="modify-btn" data-id="%s">modify</span></td></tr>' % (info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],info[0])
#         str = str + s
#     str = '<tr><td>IP</td><td>CLUSTER</td><td>SERVER</td><td>TYPE</td><td>Operator</td><td>Monitor</td><td>Contact</td><td>STATUS</td><td>OPERATION</td></tr>' + str
#     return str
#
# #登录
# @app.route('/')
# def index():
#     return render_template('login.html')
#
# @app.route('/login',methods=['GET','POST'])
# def login():
#     global username
#     if request.method == 'POST':
#         username = request.form.get('username')
#         passwd = request.form.get('passwd')
#         if username == "anbaoyong" or  username == "admin":
#             session[username] = username
#             return redirect('/html')
#
#         else:
#             return redirect('/')
#     return redirect('/')
# #登出
# @app.route('/logout')
# def logout():
#     session.pop('username', None)
#     return redirect('/')
#
#
#
#
#
#
#
#
# #主页
# @app.route('/html')
# def html():
#     if username in session:
#
# 	    return	render_template('index.html')
#     else:
#         return redirect('/')
# #查询
# @app.route('/search')
# def info():
#     ip = request.args.get('ip')
#     ip = ip.strip()
#     str = ''
#     if ip:
#         sql = 'select * from IP_list where ip like ' + "'%%%s%%'" % ip
#         cur = db.execute(sql)
#         return str_html(cur.fetchall())
#
#
#
#
# #弹窗修改模块
# @app.route('/modify')
# def modify():
# 	id = request.args.get('id')
# 	id.strip()
# 	if id:
# 		d = {}
# 		sql = 'select * from IP_list where id="%s"' % id
#         cur = db.execute(sql)
#         for info in cur.fetchall():
# 			d['id'] = info[0]
# 			d['ip'] = info[1]
# 			d['status'] = info[8]
#
#         return json.dumps(d)
#
#
#
# #修改数据库并返回修改的值，status不能为空
# @app.route('/updata')
# def updata():
#     print request.args.keys()
#     status = request.args.get('status')
#     id = request.args.get('id')
#     sql1 = 'update IP_list set status=\'%s\' where id=\'%s\''  % (status,id)
#     sql2 = 'select * from IP_list where id="%s"' % id
#     if status:
#         cur = db.execute(sql1)
#         cur = db.execute(sql2)
#         return str_html(cur.fetchall())
#
#
# #上传文件uploadfile
# @app.route('/uploadfile')
# def upload_file():
#     return render_template('/upload.html')
#
#
#
#
#
# if __name__ == '__main__':
#     username = ''
#     app.secret_key = 'A0Zr98j/3yX R~XHH!jmN]LWX/,?RT'
#     app.run(host='0.0.0.0',port=80,debug=True)
#
#
#
#
