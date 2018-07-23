import pygame
import math

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
