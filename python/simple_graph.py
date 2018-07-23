#!/usr/bin/python
import pygame
from math import pi

pygame.init()
screen = pygame.display.set_mode([800, 600])
screen.fill((20, 20, 20))

pygame.draw.circle(screen, (0, 255, 0), [100, 100], 25)
pygame.draw.line(screen, (0, 255, 0), [0, 0], [50, 30], 5)
pygame.draw.lines(screen, (0, 255, 0), False, [[0, 80], [50, 90], [200, 80], [220, 30]], 5)
pygame.draw.aaline(screen, (0, 255, 0), [0, 50], [50, 80], True)
pygame.draw.rect(screen, (0, 255, 0), [75, 10, 50, 20], 2)
pygame.draw.rect(screen, (0, 255, 0), [150, 10, 50, 20])
pygame.draw.ellipse(screen, (255, 0, 0), [225, 10, 50, 20], 2) 
pygame.draw.ellipse(screen, (255, 0, 0), [300, 10, 50, 20]) 
pygame.draw.polygon(screen, (0, 255, 0), [[100, 100], [0, 200], [200, 200]], 5)
pygame.draw.arc(screen, (0, 255, 0), [210, 75, 150, 125], 0, 1, 2)
pygame.draw.circle(screen, (0, 0, 255), [60, 250], 40)

pygame.display.flip()
pygame.time.wait(5000)
