#!/bin/python3
from flask import Flask, render_template
from random import random
from time import sleep
from threading import Thread, Event

app=Flask(__name__, template_folder='html')

@app.route('/')
def index():
	return render_template('index.html')

@app.route('/another')
def another():
	return "Another page!"

if __name__=='__main__':
	app.run(host= '0.0.0.0')
