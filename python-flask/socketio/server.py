#!/bin/python3
#Based on https://github.com/shanealynn/async_flask
from flask_socketio import SocketIO, emit
from flask import Flask, render_template, url_for, copy_current_request_context
from random import random
from time import sleep
from threading import Thread, Event

app=Flask(__name__, template_folder='html', static_url_path='/html')
socketio=SocketIO(app, async_mode=None, logger=False, engineio_logger=False)

thread=Thread()
thread_stop_event=Event()
def randomNumberGenerator():
	while not thread_stop_event.isSet():
		number=round(random()*10, 3)
		socketio.emit('log', {'data': number}, namespace='/log')
		socketio.sleep(0.01)

@app.route('/')
def index():
	return render_template('index.html')

@socketio.on('connect', namespace='/log')
def test_connect():
	global thread
	print('Client connected')
	if not thread.isAlive():
		print("Starting Thread")
		thread=socketio.start_background_task(randomNumberGenerator)

@socketio.on('disconnect', namespace='/log')
def test_disconnect():
	print('Client disconnected')

if __name__=='__main__':
	socketio.run(app, host= '0.0.0.0')
