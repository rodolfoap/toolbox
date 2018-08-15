// Set maxInteraction to a positive number to stop after a number of bounces, or zero to never stop
int maxInteraction=0;

// Choose the balls number. Careful: you would need to define its initial locations.
int totalBalls=10;

// Choose the ball radius; mass is always 1.
int radius=30;

int interaction=0, rWall=width, lastX=0, lastY=0;
float totalEnergy = 0;
float totalEntropy = 0;
Ball[] balls=new Ball[totalBalls];
int[] entropy;

void setup() {
  size(1000, 400);
  interaction=0; 
  rWall=radius*4;
  entropy=new int[width];

  // Ball 0 has the energy to disperse.
  balls[0]=new Ball(radius*1.5, radius*1.5, new PVector(3, 4), 0);
  for(int number=1; number<totalBalls; number++) 
  // Initially, we need energy>0 in order to have a positive entropy.
  balls[number]=new Ball(radius*3 + number*radius*2.5, radius*1.5, new PVector(0, 0.01), number);
  calculateEntropy();
}

void draw() {
  background(0);
  stroke(color(0, 255, 0));
  for (Ball b : balls) {
    b.update();
    b.display();
    b.checkBorderCollision();
  }
  for(int i=0; i<balls.length; i++) {
    for(int j=i+1; j<balls.length; j++) { 
      balls[i].checkBallCollision(balls[j]);
    }
  }
  drawWall();
  drawEntropy();

}

void mouseClicked() {
  if(rWall<width) {
    rWall=width; 
  } else {
    rWall=radius*4; 
    setup();
  }
}
