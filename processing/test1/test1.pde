int x = 0;

void setup() {
  fullScreen();
  background(0);
  noStroke();
  fill(102);
  noLoop();
}

void draw() {
  rect(x, height*0.2, 1, height*0.6); 
  x = x + 2;
  fill(255);
  ellipse(width/2,height/2,100,100);
  noSmooth();
  point(30, 20, -50);
  point(85, 20, -50);
  point(85, 75, -50);
  point(30, 75, -50);
}
