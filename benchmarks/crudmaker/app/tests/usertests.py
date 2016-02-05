import json
import random
import unittest
from app import create_app

test_app = create_app('conf.config')
email = "test" + str(random.randint(0, 1000)) + "@flask.com"
add_data = """{"data":{
    "attributes":
    {"active": "true", "role": "test string",
     "password": "test string",
      "creation_time": "2015-12-22",
       "modification_time": "2015-12-22",
        "email": "{user_email}",
        "name": "test string"},
    "type": "users"
  }
}"""
add_data = add_data.replace("{user_email}", email)
print(add_data)

update_data = """{
  "data": {
    "attributes":

        {"active": "false", "role": "test string", "password": "test string", "creation_time": "2015-12-22T03:12:58.019077+00:00", "modification_time": "2015-12-22T03:12:58.019077+00:00", "email": "testing@flask.pocoo.com", "name": "test string"},
    "type": "users"
  }

}"""


class TestUserResource(unittest.TestCase):
    def setUp(self):
        self.app = test_app.test_client()

    def test_01_add(self):
        rv = self.app.post('/api/v1/users', data=add_data
                           , content_type="application/json")
        print(rv.data.decode('utf-8'))
        assert rv.status_code == 201

    def test_02_get(self):
        rv = self.app.get('/api/v1/users')
        result = json.loads(rv.data.decode('utf-8'))
        id = result['data'][0]['id']
        request_url = '/api/v1/users/{0}'.format(id)
        rv = self.app.get(request_url)
        assert rv.status_code == 200

    def test_03_update(self):
        request = self.app.get('/api/v1/users')
        dict = json.loads(request.data.decode('utf-8'))
        id = dict['data'][0]['id']
        rv = self.app.patch('/api/v1/users/{}'.format(id),
                            data=update_data, content_type="application/json")
        assert rv.status_code == 200

    def test_03_delete(self):
        request = self.app.get('/api/v1/users')
        dict = json.loads(request.data.decode('utf-8'))
        id = dict['data'][0]['id']
        rv = self.app.delete('/api/v1/users/{}'.format(id))
        assert rv.status_code == 204

if __name__ == '__main__':
    unittest.main()
