import unittest

from zabbix.zabbixclient import ZabbixClient


class TestZabbixTemplateClient(unittest.TestCase):
    def setUp(self):
        self.zapi = ZabbixClient()
        self.zapi.login_in()

    def test_create_host_group(self):
        host_group = self.zapi.hostgroup.create(
            name='TEST_TEMPLATE_GROUP'
        )
        print(host_group['groupids'][0])

    def test_delete_host_group(self):
        host_group = self.zapi.hostgroup.delete('36')
        print(host_group)

