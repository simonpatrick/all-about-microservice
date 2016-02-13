from datetime import datetime
from unittest import TestCase

from app.utils.filters import timesince


class TestTimesince(TestCase):
    def setUp(self):
        self.time_period_dict = {}
        self.time_period_dict['today'] = datetime.now()
        self.time_period_dict['month_ago'] = datetime.now().month + 1
        self.time_period_dict['year_ago'] = datetime.now().day + 368
        self.time_period_dict['one_hour_ago'] = datetime.now().hour + 1
        self.time_period_dict['minutes_ago'] = datetime.now().minute + 20
        self.time_period_dict['seconds_ago'] = datetime.now().second + 70
        self.time_period_dict['ms_ago'] = datetime.now().microsecond + 30

    def test_right_now(self):
        assert timesince(self.time_period_dict['today']) == 'right now'

    def test_month_ago(self):
        assert timesince(self.time_period_dict['month_ago']) == "1 months ago"
