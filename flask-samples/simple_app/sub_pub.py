__author__ = 'patrick'

from redis import Redis
from flask import Response, stream_with_context,json, redirect, url_for
redis = Redis()
@app.route('/streams/interesting')
def stream():
    def generate():
        pubsub = redis.pubsub()
        pubsub.subscribe('interesting-channel')
        for event in pubsub.listen():
            if event['type'] == 'message':
                yield 'data: %s\r\n\r\n' % event['data']
    return Response(stream_with_context(generate()),
                    direct_passthrough=True,
                    mimetype='text/event-stream')

@app.route('/create-something', methods=['POST'])
def create_something():
    create_that_thing()
    redis.publish('interesting-channel', json.dumps({
        'event': 'created',
        'kind': 'something'
    }))
    return redirect(url_for('index'))