#!/usr/bin/python
import pygame

class Engine:
	def __init__(self, title='example', width=1280, height=800): 
		pygame.init()

		self.screen=pygame.display.set_mode((width, height))
		pygame.display.set_caption(title)
		pygame.display.toggle_fullscreen()
		pygame.mouse.set_visible(0)
		self.background=pygame.Surface(self.screen.get_size()).convert()
		self.background.fill((92, 92, 92))
		self.sprites=pygame.sprite.RenderUpdates()
		self.players=pygame.sprite.RenderUpdates()
		self.clock=pygame.time.Clock()
		self.keepGoing=True

	def setBackground(self):
		self.screen.blit(self.background, (0, 0))
		pygame.display.flip()

	def addWindow(self, window):
		self.sprites.add(window)

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
			self.sprites.update()
                        self.sprites.clear(self.screen, self.background)
                        pygame.display.update(self.sprites.draw(self.screen))

			self.clock.tick(90)

class Window(pygame.sprite.Sprite):
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image=pygame.Surface((1080, 600)).convert()
		#elf.image=pygame.image.load('car.png').convert()
		self.image.fill((155, 155, 55))
		self.rect=self.image.get_rect()
		self.rect.center=(640, 400)

engine=Engine("Pong")
window=Window()

engine.setBackground()
engine.addWindow(window)
engine.loop()

