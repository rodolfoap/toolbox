#!/usr/bin/python

import pygame
import os
import thread
pygame.init()
WIDTH=1280
HEIGHT=800
YELLOW=(255, 192, 0)
BLACK=(10, 10, 10)
device0X=WIDTH/3
device1X=WIDTH/3*2

def ThreadMouse0(*args):
	global device0X
	f = open("/dev/hidraw0")
	while (True):
	        dat1=ord(f.read(1))
	        dat2=ord(f.read(1))
	        dat3=ord(f.read(1))
	        dat4=ord(f.read(1))
		if(dat2<127): device0X+=(dat2)
		if(dat2>128): device0X-=(256-dat2)
		if(device0X<0): device0X=0
		if(device0X>999): device0X=999

def ThreadMouse1(*args):
	global device1X
	f = open("/dev/hidraw1")
	while (True):
	        dat1=ord(f.read(1))
	        dat2=ord(f.read(1))
	        dat3=ord(f.read(1))
	        dat4=ord(f.read(1))
		if(dat2<127): device1X+=(dat2)
		if(dat2>128): device1X-=(256-dat2)
		if(device1X<0): device1X=0
		if(device1X>999): device1X=999

thread.start_new_thread(ThreadMouse0,())
thread.start_new_thread(ThreadMouse1,())

screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Test")
pygame.display.toggle_fullscreen()
pygame.mouse.set_visible(0)

background = pygame.Surface(screen.get_size()).convert()
background.fill(YELLOW)

car1 = pygame.Surface((int(WIDTH/100), int(HEIGHT/15))).convert()
car1.fill(BLACK)
car2 = pygame.Surface((int(WIDTH/100), int(HEIGHT/15))).convert()
car2.fill(BLACK)

car1_x = int(WIDTH*0.6)
car1_y = HEIGHT-100
car2_x = int(WIDTH*0.3)
car2_y = HEIGHT-100

clock = pygame.time.Clock()
keepGoing = True
HWIDTH=int(WIDTH/2)

while keepGoing:

	#clock.tick(200)

	for event in pygame.event.get():
		#print event
		if event.type == pygame.QUIT:
			keepGoing = False
		if event.type == pygame.KEYDOWN:
			if event.key == pygame.K_ESCAPE or event.unicode == 'q':
				keepGoing = False

		car1_x=int(float(device0X)/1000*WIDTH/2)
		car2_x=int(float(device1X)/1000*WIDTH/2)+WIDTH/2

	screen.blit(background, (0, 0))
	screen.blit(car1, (car1_x, car1_y))
	screen.blit(car2, (car2_x, car2_y))
	pygame.display.flip()

