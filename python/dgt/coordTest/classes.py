import os, sys, pygame
from pygame.locals import *

def load_image(name, colorkey=None):
	#image=pygame.image.load(os.path.join('data', name)).convert()
	image=pygame.image.load(os.path.join('data', name))
	if colorkey is not None:
		if colorkey is -1: colorkey = image.get_at((0,0))
		image.set_colorkey(colorkey, RLEACCEL)
	return image, image.get_rect()

def load_sound(name):
	sound=pygame.mixer.Sound(os.path.join('data', name))
	return sound

class Beep:
	def __init__(self):
		self.sound = load_sound("beep.wav")
	def play(self):
		self.sound.play()

class Arena(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image, self.rect = load_image("arena.gif", -1)
		self.dy = 3
		self.reset()
	def update(self):
		self.rect.bottom += self.dy
		if self.rect.top >= 0:
			self.reset() 
	def reset(self):
		self.rect.top = -(5400-800)

class Car(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image = pygame.Surface((10, 50)).convert()
		self.rect=self.image.get_rect()
		self.image.fill((10, 10, 10))
		self.reset()
	def update(self):
		self.rect.center=(self.x, self.y)
	def reset(self):
		self.x = 0
		self.y = 700
		self.rect.center=(80, 80)

