import os
import subprocess
import time

__author__ = 'patrick'


class DNSService():
    def __init__(self):
        pass

    def change_dns_with_command(self, command, ips):
        start_time = time.strftime('%Y%m%d_%H%M', time.localtime())
        dns_file = '/root/dn/domain_%s.txt' % start_time
        if not ips.strip():
            return 'IP is empty,please checkout your input ips'
        if os.path.exists(dns_file):

            modified_dns = ips.split('\r\n')
            with open(dns_file, 'w') as f:
                for i in modified_dns:
                    if i.strip():
                        f.write('%s\n')

            dns_command = 'ddnstool -a %s' % dns_file
            (return_code, std_out, std_err) = self.get_status_output(command=dns_command)

            if not return_code:
                return 'success: %s' % std_out
            else:
                return 'fail: %s' % std_err
        else:
            return 'file not exists'

    def get_status_output(self, *args, *kwargs):
        p = subprocess.Popen(*args, **kwargs)
        std_out, std_err = p.communicate()
        return p.returncode, std_out, std_err
