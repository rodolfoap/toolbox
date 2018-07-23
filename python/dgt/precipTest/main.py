#!/usr/bin/python
import pygame
import random
import time

pygame.mixer.pre_init(44100, -16, 2, 16)
pygame.init()

screen = pygame.display.set_mode((1280, 800))
pygame.display.set_caption("Window Title")
pygame.display.toggle_fullscreen()
pygame.mouse.set_visible(0)

background = pygame.Surface(screen.get_size()).convert()
background.fill((92, 92, 92))
background.fill((255, 255, 0), (0, 350, 1280, 100))

class Block(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image=pygame.Surface((400, 400)).convert()
		self.image.fill((192, 192, 192))
		self.rect=self.image.get_rect()
		self.reset()
	def update(self):
		pass
	def reset(self):
		self.rect.center=(1080, 400)

class Ball(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image = pygame.Surface((30, 30)).convert()
		self.image.fill((10, 10, 10))
		self.rect=self.image.get_rect()
		self.reset()
	def update(self):
		self.x+=self.dx
		self.rect.center=(self.x, self.y)
	def reset(self):
		self.dx=3
		self.x=50
		self.y=400
		self.rect.center=(self.x, self.y)
block=Block()
blockSprite=pygame.sprite.RenderPlain()
blockSprite.add(block)

ball=Ball()
ballSprite=pygame.sprite.RenderPlain()
ballSprite.add(ball)

allSprite=pygame.sprite.RenderPlain()
allSprite.add(block)
allSprite.add(ball)

beep=pygame.mixer.Sound('beep.wav')
beep.play()

tickBall=0
tickUser=0
keepGoing=True
clock=pygame.time.Clock()
tickStart=pygame.time.get_ticks()
while keepGoing:
	clock.tick(100)

	for event in pygame.event.get():
		if event.type==pygame.QUIT:
			keepGoing=False
		if event.type==pygame.KEYDOWN:
			if event.key==pygame.K_ESCAPE:
				keepGoing=False
			if event.unicode=='q':
				keepGoing=False
		if tickUser==0 and event.type==pygame.MOUSEBUTTONDOWN:
				tickUser=pygame.time.get_ticks()
				beep.play()
	if ball.x >1680:
		keepGoing=False
	if tickBall==0 and ball.x>=1265:
		tickBall=pygame.time.get_ticks()
	screen.blit(background, (0, 0))
	allSprite.update()
	allSprite.draw(screen)
	pygame.display.flip()

tickEnd=pygame.time.get_ticks()

timeUser=tickUser-tickStart
timeBall=tickBall-tickStart
timeDiff=tickBall-tickUser

print "User : ", str(timeUser/1000.0)
print "Ball : ", str(timeBall/1000.0)
print "Diff : ", str(timeDiff/1000.0)
if(timeDiff>0):
	print "Tendencia a retrasarse"
else:
	print "Tendencia a precipitarse"
	
time.sleep(1)
