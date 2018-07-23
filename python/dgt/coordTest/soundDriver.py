import threading, pygame, os, sys
def load_sound(name):
	sound=pygame.mixer.Sound(os.path.join('data', name))
	return sound
class soundDriver(threading.Thread):
	def __init__(self, device):
		self.sound = load_sound(device)
		self.wait = 0
		self.keepGoing=True
		print "Sound Driver started for", device
		threading.Thread.__init__(self)
	def run(self):
		self.sound.play()
		self.sound.set_volume(0.0)
		while (self.keepGoing):
			pygame.time.wait(10)
			if(pygame.mixer.get_busy()==0): self.sound.play()
			if(self.wait>0): self.wait-=1
			else: self.sound.set_volume(0.0)
	def play(self):
		self.sound.set_volume(0.5)
		if(self.wait<10): self.wait=10
	def stop(self):
		print "Sound Driver stopped"
		self.keepGoing=False

