import pygame
import math

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
