int radius=30;
int totalBalls=10;
Ball[] balls=new Ball[totalBalls];

void setup() {
  size(1000, 600);
  for(int ini=0; ini<totalBalls; ini++) balls[ini]=new Ball(radius*1.5+ini*radius*3, 40, new PVector(0, 0));
  balls[0].velocity.set(-4,2);
  printStates();
}

void draw() {
  background(0);
  stroke(color(0, 32, 0));
  for (Ball b : balls) {
    b.update();
    b.display();
    b.checkBorderCollision();
  }
  for(int i=0; i<balls.length; i++) {
    for(int j=i+1; j<balls.length; j++) { 
      balls[i].checkCollision(balls[j]);
    }
  }
}
