import threading
class mouseDriver(threading.Thread):
	def __init__(self, device, x, y):
		print "Driver started for", device
		self.device=device
		self.x=x
		self.y=y
		self.keepGoing=True
		threading.Thread.__init__(self)
	def run(self):
		try:
			self.f=open(self.device)
		except IOError:
			print "ERROR: Device permissions bad for ", self.device, "... stopping driver."
			self.stop()
		while (self.keepGoing):
			dat1=ord(self.f.read(1)) # 1=Left & 2=Right & 4=Center buttons
			dat2=ord(self.f.read(1)) # Signed Byte X
			dat3=ord(self.f.read(1)) # Signed Byte Y 
			dat4=ord(self.f.read(1)) # Others
			if(dat2<127): self.x+=(dat2)
			if(dat2>128): self.x-=(256-dat2)
			if(self.x<0): self.x=0
			if(self.x>999): self.x=999
	def stop(self):
		print "Driver stopped for", self.device
		self.keepGoing=False
