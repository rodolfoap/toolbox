Thing d=new Thing();
float i=-1.0f;

void setup() {
  size (500, 300);
  smooth();
  strokeWeight(1);
  background(0);
  d.prepare();
  noFill();
}

void draw() {
  i+=0.1;
  if (i<2.0f) {
    PVector position=d.move(i);
    println("Position["+i+"]: ("+position.x+", "+position.y+")");
    stroke(0, 255, 0);
    ellipse(d.position.x, d.position.y, 10, 10);
    delay(500);
  }
}
