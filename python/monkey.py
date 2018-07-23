#!/usr/bin/python

import pygame, sys,os
from pygame.locals import * 
 
pygame.init() 
 
window = pygame.display.set_mode((800, 600)) 
pygame.display.set_caption('Monkey Fever') 
screen = pygame.display.get_surface() 

monkey_head_file_name = os.path.join("data","chimp.bmp")
monkey_surface = pygame.image.load(monkey_head_file_name)

screen.blit(monkey_surface, (20,20)) 
pygame.display.flip() 
 
def input(events): 
	for event in events: 
		if event.type == KEYDOWN: 
			screen.blit(monkey_surface, (40,40)) 
			pygame.display.flip() 
			print event 
			sys.exit(0) 
		if event.type == QUIT: 
			print event 
			sys.exit(0) 
		else: 
			print event 
 
while True: 
	input(pygame.event.get()) 

