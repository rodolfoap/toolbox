#!/usr/bin/python
import os, sys, pygame, random
from pygame.locals import *
from classes import Arena
from classes import Car
from classes import Beep
from mouseDriver import mouseDriver
from soundDriver import soundDriver

os.environ['SDL_VIDEO_CENTERED'] = "1"
FULLSCREEN=True
MOUSESWITCH=True

pygame.mixer.pre_init(44100, -16, 2, 16)
pygame.init()
if(FULLSCREEN):
	screen = pygame.display.set_mode((1280, 800))
	pygame.display.toggle_fullscreen()
else:
	screen = pygame.display.set_mode((1240, 750))
WIDTH, HEIGHT= screen.get_size()

pygame.display.set_caption("Coordination test")
pygame.mouse.set_visible(0)

mouse0=mouseDriver("/dev/hidraw0", 499, 0)
mouse1=mouseDriver("/dev/hidraw1", 499, 0)
beep = soundDriver("beep.wav")
mouse0.start()
mouse1.start()
beep.start()

background = pygame.Surface(screen.get_size()).convert()
background.fill((92, 92, 92))

arena = Arena()
arena = pygame.sprite.RenderPlain((arena))

car1 = Car()
car1Sprite = pygame.sprite.RenderPlain((car1))

car2 = Car()
car2Sprite = pygame.sprite.RenderPlain((car2))

clock = pygame.time.Clock()

def is_rect_out(rectangle):
	isOver=False
	global screen
	x1=rectangle[0]
	x2=rectangle[0]+rectangle[2]
	y1=rectangle[1]
	y2=rectangle[1]+rectangle[3]
	if(screen.get_at((x1, y1))[0]<100): isOver=True
	if(screen.get_at((x2, y1))[0]<100): isOver=True
	if(screen.get_at((x1, y2))[0]<100): isOver=True
	if(screen.get_at((x2, y2))[0]<100): isOver=True
	return isOver

keepGoing=(mouse0.keepGoing and mouse1.keepGoing and beep.keepGoing)
while keepGoing:
	clock.tick(200)

	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			keepGoing = False
		if event.type == pygame.KEYDOWN:
			if event.unicode == 's':
				MOUSESWITCH = not MOUSESWITCH
			if event.key == pygame.K_ESCAPE or event.unicode == 'q':
				keepGoing = False
	if(MOUSESWITCH):
		car1.x=int(float(mouse1.x)/1000*WIDTH*0.4+WIDTH*0.05)
		car2.x=int(float(mouse0.x)/1000*WIDTH*0.4+WIDTH*0.55)
		pygame.display.set_caption("LEFT:"+str(MOUSESWITCH))
	else:
		car1.x=int(float(mouse0.x)/1000*WIDTH*0.4+WIDTH*0.05)
		car2.x=int(float(mouse1.x)/1000*WIDTH*0.4+WIDTH*0.55)
		pygame.display.set_caption("RIGHT:"+str(MOUSESWITCH))

	screen.blit(background, (0, 0))
	arena.update()
	arena.draw(screen)
	if(is_rect_out(car1.rect)):
		beep.play()
	if(is_rect_out(car2.rect)):
		beep.play()
	car1.update()
	car1Sprite.draw(screen)
	car2.update()
	car2Sprite.draw(screen)
	pygame.display.flip()
	keepGoing=(keepGoing and mouse0.keepGoing and mouse1.keepGoing and beep.keepGoing)

mouse0.stop()
mouse1.stop()
beep.stop()
sys.exit()
