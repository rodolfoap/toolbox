#!/usr/bin/python

import pygame
import random
 
class Block(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self) 
		self.image=pygame.Surface((40, 40))
		self.image.fill((0, 0, 0))
		self.rect=self.image.get_rect()
	def draw(self, surface):
		surface.blit(self.image,(self.rect.x, self.rect.y))
 
pygame.init()
screen=pygame.display.set_mode([300, 200])
 
block_list = pygame.sprite.Group()
player = Block()
for i in range(8000):
	block = Block()
	block.rect.x = random.randrange(300-40-1)+1
	block.rect.y = random.randrange(200-40-1)+1
	block_list.add(block)
	 
clock = pygame.time.Clock()
done = False
while done==False:
	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			done = True
	screen.fill((255, 255, 255))
 
	pos = pygame.mouse.get_pos()
	player.rect.x = pos[0]
	player.rect.y = pos[1]
	blocks_hit_list = pygame.sprite.spritecollide(player, block_list, True)  
	print block_list.len
	pygame.sprite.spritecollide(player, block_list, True)  
	block_list.draw(screen)
	player.draw(screen)
	 
	clock.tick(20)
	pygame.display.flip()
pygame.quit()
