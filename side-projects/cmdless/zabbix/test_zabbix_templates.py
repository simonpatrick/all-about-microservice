import unittest

from zabbix.zabbixclient import ZabbixClient


class TestZabbixTemplateClient(unittest.TestCase):

    def setUp(self):
        self.zapi = ZabbixClient()
        self.zapi.login_in()

    def test_get_template(self):
        templates = self.zapi.template.get()
        print(templates)

    def test_get_template(self):
        templates = self.zapi.template.get(
            filter={
                "host": ["Template OS Linux"]
            })
        print(templates[0]["id"])

    def test_create_template(self):
        template = self.zapi.template.create()
