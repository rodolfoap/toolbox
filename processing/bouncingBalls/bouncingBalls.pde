int radius=30;
int totalBalls=10;
Ball[] balls=new Ball[totalBalls];

void setup() {
  size(1000, 600);
  balls[0]=new Ball(radius*1.5, 40, new PVector(-2, 2));
  for(int ini=1; ini<totalBalls; ini++) 
  balls[ini]=new Ball(radius*1.5+ini*radius*3, 40, new PVector(0, 0.1));
  printStates();
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
      balls[i].checkCollision(balls[j]);
    }
  }
//  line(0, height-totalEntropy/2, 10, height-totalEntropy/2);
}
