Observ[] observ=new Observ[2];
Target[] target=new Target[0];
int SPEED=5;
long ts=-1; 

void setup() {
  size (400, 400);
  smooth();
  noFill();
  strokeWeight(1);
  background(0);
  for (int i=0; i<observ.length; i++) observ[i]=new Observ(i, SPEED);
}

void draw() {
  background(0);

  // Rendering
  for (int i=0; i<observ.length; i++) {
    observ[i].move();
    observ[i].render();
  }

  // Tracking
  if (++ts%25==0) doTracking();
  delay(40);
}
