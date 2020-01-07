#!/usr/bin/python3

from threading import Thread
import time
import subprocess
from websocket_server import WebsocketServer

lastclient=None
def on_new_client(client, server):
	global lastclient
	lastclient=client
	server.send_message_to_all("Hey all, a new client has joined us")
	server.send_message(client, "Welcome, client "+str(client['id']))

def on_client_leave(client, server):
	print("Client[%d] left" % client['id'])

# Called when a client sends a message
def on_message_received(client, server, message):
	print("Message from client[%d]: %s" % (client['id'], message))

def threaded_function(arg):
	global lastclient
	while True:
		if(lastclient):
			bashCommand = "date +%s%N"
			process = subprocess.Popen(bashCommand.split(), stdout=subprocess.PIPE)
			output, error = process.communicate()
			server.send_message(lastclient, output)
		time.sleep(0.2)

server=WebsocketServer(8080, host='0.0.0.0')
server.set_fn_new_client(on_new_client)
server.set_fn_client_left(on_client_leave)
server.set_fn_message_received(on_message_received)

thread = Thread(target = threaded_function, args = (10, ))
thread.start()
#hread.join()

server.run_forever()

