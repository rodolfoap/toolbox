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
