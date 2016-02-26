import json
from unittest import TestCase
import httpretty

from zabbix.zabbixclient import ZabbixClient


# @httpretty.activate
class TestZabbixAPIClient(TestCase):
    def test_login(self):
        httpretty.register_uri(
            httpretty.POST,
            "http://java.zabbix.dooioo.com/api_jsonrpc.php",
            body=json.dumps({
                "jsonrpc": "2.0",
                "result": "0424bd59b807674191e7d77572075f33",
                "id": 0
            }),
        )

        zapi = ZabbixClient()
        zapi.login_in()
        # Check request
        self.assertEqual(
            json.loads(httpretty.last_request().body.decode('utf-8')),
            {
                'jsonrpc': '2.0',
                'method': 'user.login',
                'params': {'user': '110863', 'password': '123456'},
                'id': 0,
                'auth': ''
            }
        )
        self.assertEqual(
            httpretty.last_request().headers['content-type'],
            'application/json-rpc'
        )
        self.assertEqual(
            httpretty.last_request().headers['user-agent'],
            'python-zabbix-client'
        )

        # Check response
        self.assertEqual(zapi.auth, "0424bd59b807674191e7d77572075f33")

    def test_get_host(self):
        zapi = ZabbixClient()
        zapi.login_in()
        hosts = zapi.host.get()
        self.assertIsNotNone(hosts)

    def test_get_item(self):
        zapi = ZabbixClient()
        zapi.login_in()
        templates = zapi.template.get()
        print(templates)
        for item in templates:
            print(item['name'])
            for k, v in item.items():
                print(k, v)
        self.assertIsNotNone(templates)
