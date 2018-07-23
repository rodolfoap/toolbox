#!/usr/bin/python
import pygame
import math
from engine import Engine
from ball import Ball
from block import Block
			
engine=Engine("Pong")
block=Block()
ball=Ball()

engine.setBackground()
engine.addPlayer(block)
engine.addBall(ball)
engine.loop()

