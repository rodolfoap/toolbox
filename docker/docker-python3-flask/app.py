#!/usr/bin/env python3
import json
from flask import Flask, request, render_template, send_from_directory, abort

class ApiServer:
	def __init__(self, api):

		@api.route('/')
		def api_index():
			return('Hello, World!')

		@api.route('/favicon.ico')
		def api_favicon():
			return send_from_directory(api.root_path+'/lib/', 'favicon.ico', mimetype='image/vnd.microsoft.icon')

		@api.route("/user")
		def api_user():
			abort(404);

app=Flask(__name__, template_folder='tpl', static_folder='lib')
server=ApiServer(app)
if __name__=="__main__": app.run(host='0.0.0.0', port=8000) # ssl_context='adhoc')
