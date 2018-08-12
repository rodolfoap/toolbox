int ballNumber=0;
float minDistance = 2*radius;
class Ball {
  PVector position;
  PVector velocity;
  int name;
  float initialEnergy; 
  Ball(float x, float y, PVector v) {
    position = new PVector(x, y);
    velocity=v;
    initialEnergy=energy();
    name=ballNumber++;
  }

  float energy(){
    return sq(velocity.mag())/2;
  }

  float entropy(){
    if(initialEnergy==0) return 0;
    return (energy()-initialEnergy)/initialEnergy;
  }

  void update() {
    position.add(velocity);
  }

  void display() {
    fill(color(0, 256, 0));
    ellipse(position.x, position.y, radius*2, radius*2);
    fill(color(0, 0, 0));
    text(this.name, position.x-4, position.y+4); 
  }
  
  void checkBorderCollision() {
    if (position.x > width-radius) {
      position.x = width-radius;
      velocity.x *= -1;
    } else if (position.x < radius) {
      position.x = radius;
      velocity.x *= -1;
    } else if (position.y > height-radius) {
      position.y = height-radius;
      velocity.y *= -1;
    } else if (position.y < radius) {
      position.y = radius;
      velocity.y *= -1;
    }
  }

  void checkCollision(Ball other) {
	PVector distanceVect = PVector.sub(other.position, position);
	float distanceVectMag = distanceVect.mag();
	if (distanceVectMag < minDistance) { // Collision!

		// Correct distance to avoid overlapping: move the other
		PVector distanceVectFixed=distanceVect.copy().normalize().mult(minDistance-distanceVect.mag());
		other.position.add(distanceVectFixed); 

		// Rotate both speeds to emulate bouncing on a vertical wall
		velocity.rotate(-distanceVectFixed.heading());
	        other.velocity.rotate(-distanceVectFixed.heading());
        
		// Then, simply exchange horizontal speeds 
		float tempX=velocity.x;
		velocity.x=other.velocity.x;
		other.velocity.x=tempX;
	
		// Rotate back to original coordinates
	        velocity.rotate(distanceVectFixed.heading());
	        other.velocity.rotate(distanceVectFixed.heading());

	 	printStates();
	}
  }
}
