import json
import logging

import requests


class _NullHandler(logging.Handler):
    def emit(self, record):
        pass


class ZabbixAPIException(Exception):
    pass


logger = logging.getLogger(__name__)
logger.addHandler(_NullHandler())


class ZabbixClient:
    """
    Generic Zabbix API Client
    - login
    - get auth
    """
    globale_header = {
        "Content-Type": "application/json-rpc"
    }

    def __init__(self, session=None, timeout=None):

        if session:
            self.session = session
        else:
            self.session = requests.session()

        self.session.headers.update({
            'Content-Type': 'application/json-rpc',
            'User-Agent': 'python-zabbix-client',
            'Cache-Control': 'no-cache'
        })

        self.auth = ''
        self.id = 0
        self.timeout = timeout
        logger.info('JSON-RPC Server EndPoint: %s', self.zabbix_api_url)

    def login_in(self, user_name=None, password=None):
        """
        login with given user_name and password, if None, use default user
        :param user_name:
        :param password:
        :return: result,auth key
        """
        if user_name:
            self.user_name = user_name

        if password:
            self.password = password

        self.auth = self.user.login(user=self.user_name, password=self.password)

    def api_version(self):
        return self.apiinfo.version()

    # def confimport(self, format='', source='', rules=''):
    #     """Alias for configuration.import because it clashes with
    #        Python's import reserved keyword"""
    #
    #     return self.do_request(
    #         method="configuration.import",
    #         params={"format": format, "source": source, "rules": rules}
    #     )['result']

    def do_request(self, method, params=None):
        request_json = {
            'jsonrpc': '2.0',
            'method': method,
            'params': params or {},
            'id': self.id,
        }

        if method != 'apiinfo.version' and self.auth:
            request_json['auth'] = self.auth

        logger.debug("sending: %s", json.dumps(request_json, indent=4, separators=(',', ':')))
        response = self.session.post(
            self.zabbix_api_url,
            data=json.dumps(request_json),
            timeout=self.timeout
        )
        logger.debug("Response Code : %s", str(response.status_code))

        response.raise_for_status()

        if not len(response.text):
            raise ZabbixAPIException("没有返回值")

        try:
            response_json = json.loads(response.text)
        except ValueError:
            raise ZabbixAPIException("不能解析JSON %s" % response.text)

        logger.debug("sending: %s", json.dumps(request_json, indent=4, separators=(',', ':')))

        self.id += 1

        if 'error' in response_json:
            if 'data' not in response_json['error']:
                response_json['error']['data'] = 'No Data'
            msg = "Error {code}: {message},{data}".format(
                code=response_json['error']['code'],
                message=response_json['error']['message'],
                data=response_json['error']['data']
            )
            raise ZabbixAPIException(msg, response_json['error']['code'])

        return response_json

    def __getattr__(self, item):
        """
        auto create Zabbix API Client
        :param item:
        :return:
        """
        return ZabbixAPIObjectClass(item, self)


class ZabbixAPIObjectClass(object):
    def __init__(self, name, parent):
        self.name = name
        self.parent = parent

    def __getattr__(self, item):
        """
        dynamic create a method (get,create,update,delete)
        :param item:
        :return:
        """

        def fn(*args, **kwargs):
            if args and kwargs:
                raise TypeError('Found Both args and kwargs')

            return self.parent.do_request('{0}.{1}'.format(self.name, item),
                                          args or kwargs)['result']

        return fn
