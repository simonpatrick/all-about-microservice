__author__ = 'patrick'

db_config = {
    'host': 'localhost',
    'user': 'root',
    'passwd': '',
    'db': 'ops'
}

page_config = {
    "domain_name": "dev_ops",
    "title": "Hello Dev Ops",
    "favicon": 'https://pic1.zhimg.com/6d660dd4156c64bfad13ff97d79c2f98_l.jpg',
    "menu": [
        {
            # user配置最好不要修改，是和登陆认证相关的，直接在下面加配置即可
            "name": 'user',
            "title": '用户管理',
            "data": [{
                "name": 'username',
                "title": '用户名'
            }, {
                "name": 'password',
                "title": '密码'
            }]
        },
        {
            "name": 'caninet',
            "title": '机柜',
            "data": [{
                "name": "name",
                "title": '机柜名'
            }]
        },
        {
            "name": "host",
            "title": "服务器",
            "data": [{
                "name": "caninet",
                "title": '机柜',
                "type": 'select',
                "select_type": 'caninet'
            }, {
                "name": "hostname",
                "title": '主机名'
            }, {
                'name': 'asset_no',
                'title': '资产号'
            }, {
                "name": 'end_time',
                "title": "过期日期",
                "type": 'date'
            }, {
                "name": 'ups',
                "title": '是否开启',
                "type": 'select',
                "value": {0: '开启', 1: '关闭'}
            }]
        }
    ]
}
