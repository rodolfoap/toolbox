#!/usr/bin/python
import pygame
import math

class Engine:
	def __init__(self, title='example', width=800, height=600): 
		pygame.mixer.pre_init(44100, -16, 2, 16)
		pygame.init()

		self.screen=pygame.display.set_mode((width, height))
		pygame.display.set_caption(title)
		pygame.display.toggle_fullscreen()
		pygame.mouse.set_visible(0)
		self.background=pygame.Surface(self.screen.get_size()).convert()
		self.background.fill((92, 92, 92))
		self.background.fill((255, 255, 255), (0, 0, 800, 48))
		self.sprites=pygame.sprite.RenderUpdates()
		self.players=pygame.sprite.RenderUpdates()
		self.clock=pygame.time.Clock()
		self.keepGoing=True

	def setBackground(self):
		self.screen.blit(self.background, (0, 0))
		pygame.display.flip()

	def addPlayer(self, sprite):
		self.sprites.add(sprite)
		self.players.add(sprite)

	def addBall(self, sprite):
		self.sprites.add(sprite)
		self.ball=sprite

	def loop(self):
		while self.keepGoing:
			for event in pygame.event.get():
				if event.type==pygame.QUIT:
					self.keepGoing=False
				if event.type==pygame.KEYDOWN:
					if event.key==pygame.K_ESCAPE:
						self.keepGoing=False
					if event.unicode=='q':
						self.keepGoing=False
			for crash in pygame.sprite.spritecollide(self.ball, self.players, False):
				self.ball.swapX()
			self.sprites.update()
			self.sprites.clear(self.screen, self.background)
			pygame.display.update(self.sprites.draw(self.screen))

			self.clock.tick(90)

class Block(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image=pygame.Surface((20, 92)).convert()
		#elf.image=pygame.image.load('car.png').convert()
		self.image.fill((255, 255, 255))
		self.rect=self.image.get_rect()
		self.reset()
	def update(self):
		self.rect.centery=pygame.mouse.get_pos()[1]
	def reset(self):
		self.rect.center=(100, 100)

class Ball(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image=pygame.Surface((10, 14)).convert()
		#elf.image=pygame.image.load('car.png').convert()
		self.image.fill((255, 255, 255))
		self.rect=self.image.get_rect()
		self.beep=pygame.mixer.Sound('beep.wav')
		self.clock=pygame.time.Clock()
		self.reset()
	def reset(self):
		self.x, self.y=400, 300
		self.dx, self.dy=4, 4
		self.update
		self.clock.tick()
		self.hitTime=self.clock.get_time()
	def update(self):
		self.x, self.y=self.x+self.dx, self.y+self.dy
		if self.x > 800 or self.x < 0:
			if self.x<400: self.dx= 4
			if self.x>400: self.dx=-4
			self.beep.play()
		if self.y > 600 or self.y < 0:
			if self.y<400: self.dy= 4
			if self.y>400: self.dy=-4
			self.beep.play()
		self.rect.center=(self.x, self.y)
	def swapX(self):
		if self.clock.tick()>200:
			self.dx=-self.dx
			self.beep.play()
			
engine=Engine("Pong")
block=Block()
ball=Ball()

engine.setBackground()
engine.addPlayer(block)
engine.addBall(ball)
engine.loop()

