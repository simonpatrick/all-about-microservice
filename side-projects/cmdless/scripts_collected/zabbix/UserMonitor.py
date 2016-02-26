#!/usr/bin/env python

from __future__ import unicode_literals
import json
import urllib
import sys
from datetime import datetime
from optparse import OptionParser

if __name__ == '__main__':
    parser = OptionParser()
    parser.add_option('-u', '--url', default='127.0.0.1:9200')
    parser.add_option('-i', '--indice')
    parser.add_option('-k', '--key')
    options, _ = parser.parse_args()
    try:
        response = urllib.request.urlopen(
            "http://%s/%s/_stats" %
            (options.url, datetime.now().strftime(options.indice))
        )
        content = response.read()
        result = json.loads(content)
        for key in options.key.split('.'):
            result = result[key]
    except Exception:
        sys.exit(-1)
    else:
        print result