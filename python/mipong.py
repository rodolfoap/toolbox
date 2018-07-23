#!/usr/bin/env python

"""
Copyright (c) 2007 Alejandro Santos <alejolp@alejolp.com>

This software is provided 'as-is', without any express or implied
warranty. In no event will the authors be held liable for any damages
arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it
freely, subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not
claim that you wrote the original software. If you use this software
in a product, an acknowledgment in the product documentation would be
appreciated but is not required.

2. Altered source versions must be plainly marked as such, and must not be
misrepresented as being the original software.

3. This notice may not be removed or altered from any source
distribution.
"""

import os, pygame
from pygame.locals import *
import random
import math
from copy import copy

class Player:
    def __init__(self, screen):
        self.screen = screen
        self.screensize = self.screen.get_size()
        self.rect = pygame.Rect( 10, 10, 10, 60 )
        self.points = 0
        
    def up(self):
        if self.rect.y > 0:
            self.rect.y = self.rect.y - 10
    
    def down(self):
        if self.rect.y + self.rect.h < self.screensize[1]:
            self.rect.y = self.rect.y + 10

    def is_left_player(self):
        return self.rect.x < (self.screensize[0] / 2);
    
    def point(self, p):
        self.points = self.points + p

class Ball:
    def __init__(self, screen, pos):
        self.screen = screen
        self.screensize = self.screen.get_size()
        self.rect = pygame.Rect( pos[0], pos[1], 10, 10 )
        self.vx = 5
        self.vy = 5
        self.hitleft = False
        self.hitright = False
        
    def bounce_x(self):
        self.vx = -self.vx
    
    def bounce_y(self):
        self.vy = -self.vy
        
    def update(self):
        self.rect.x = self.rect.x + self.vx
        self.rect.y = self.rect.y + self.vy
        
        size = self.screensize
        if (self.rect.y <= 0) or (self.rect.y + self.rect.h >= size[1]):
            self.bounce_y()
            
        if (self.rect.x <= 0):
            self.hitleft = True
            self.bounce_x()
        elif (self.rect.x + self.rect.w >= size[0]):
            self.hitright = True
            self.bounce_x()
        
    def check_collision(self, player):
        if player.is_left_player():
            return self.rect.colliderect(player.rect) and self.vx < 0
        else:
            return self.rect.colliderect(player.rect) and self.vx > 0
    
    def get_hit_left(self):
        if self.hitleft:
            self.hitleft = False
            return True
        
    def get_hit_right(self):
        if self.hitright:
            self.hitright = False
            return True

class MiPong:
    def __init__(self):
        pygame.init()
        self.screen = pygame.display.set_mode((400, 300))
        pygame.mouse.set_visible(1)
        self.clock = pygame.time.Clock()
        self.color = (100,255,100)
        self.player1 = Player(self.screen)
        size = self.screen.get_size()
        self.ball = Ball(self.screen, (size[0] / 2, size[1] / 2))
        
    def handleEvents(self):
        for event in pygame.event.get():
            if event.type == QUIT:
                self.run = False
            elif event.type == KEYDOWN:
                if event.key == K_ESCAPE:
                    self.run = False
                    
    def checkKeys(self):
        k = pygame.key.get_pressed()
        
        if k[pygame.K_UP]:
            self.player1.up()
        elif k[pygame.K_DOWN]:
            self.player1.down()
            
    def update_title(self):
        pygame.display.set_caption("MiPong - P1: " + str(self.player1.points))
        
    def main(self):
        self.update_title()
        self.run = True
        while self.run:
            # Limitador de FPS
            self.clock.tick(23)
            self.handleEvents()
            self.checkKeys()
            self.ball.update()

            if self.ball.check_collision(self.player1):
                self.ball.bounce_x()
                self.player1.point(1)
                self.update_title()
                
            elif self.ball.get_hit_left():
                self.player1.point(-1)
                self.update_title()

            self.screen.fill((0,0,0))
            pygame.draw.rect(self.screen, self.color, self.player1.rect, 0)
            pygame.draw.rect(self.screen, self.color, self.ball.rect, 0)
            pygame.display.flip()
            
#this calls the 'main' function when this script is executed
if __name__ == '__main__':
    # Import Psyco if available
    try:
        import psyco
        psyco.log()
        psyco.full(memory=5000)
        psyco.profile(0.05, memory=5000)
        psyco.profile(0.1)
    except ImportError:
        pass
    
    p = MiPong()
    p.main()
    