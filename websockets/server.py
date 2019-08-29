#!/usr/bin/python3

from websocket_server import WebsocketServer

def on_new_client(client, server):
	server.send_message_to_all("Hey all, a new client has joined us")
	server.send_message(client, "Welcome, client "+str(client['id']))

def on_client_leave(client, server):
	print("Client[%d] left" % client['id'])

# Called when a client sends a message
def on_message_received(client, server, message):
	print("Message from client[%d]: %s" % (client['id'], message))

server=WebsocketServer(8080, host='0.0.0.0')
server.set_fn_new_client(on_new_client)
server.set_fn_client_left(on_client_leave)
server.set_fn_message_received(on_message_received)
server.run_forever()
