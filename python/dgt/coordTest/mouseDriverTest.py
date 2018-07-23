#!/usr/bin/python
import pygame
clock = pygame.time.Clock()

from mouseDriver import mouseDriver
mouse0=mouseDriver("/dev/hidraw0", 100, 300)
mouse1=mouseDriver("/dev/hidraw1", 200, 300)
mouse0.start()
mouse1.start()

for count in range(100):
	clock.tick(30)
	print mouse0.x, "\t", mouse1.x
else:
	mouse0.stop()
	mouse1.stop()
