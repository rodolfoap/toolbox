class Thing {
  PVector p0=new PVector(100, 100);
  PVector p1=new PVector(200, 100);
  PVector p2=new PVector(300, 200);
  PVector p3=new PVector(400, 200);
  PVector position;

  void prepare() {
    stroke(255, 0, 0);
    fill(255, 0, 0);
    ellipse(p0.x, p0.y, 10, 10);
    ellipse(p1.x, p1.y, 10, 10);
    ellipse(p2.x, p2.y, 10, 10);
    ellipse(p3.x, p3.y, 10, 10);
  }

  PVector move(float p) {  
    position = catmull(p, p0.x, p0.y, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    return position;
  }

  PVector catmull (float tt, float p0x, float p0y, float p1x, float p1y, float p2x, float p2y, float p3x, float p3y) {
    float xx = 0.5 * ((2*p1x) + (-p0x + p2x)*tt + (2*p0x - 5*p1x + 4*p2x -p3x) * pow(tt, 2) + (-p0x + 3*p1x - 3*p2x + p3x) * pow(tt, 3));
    float yy = 0.5 * ((2*p1y) + (-p0y + p2y)*tt + (2*p0y - 5*p1y + 4*p2y -p3y) * pow(tt, 2) + (-p0y + 3*p1y - 3*p2y + p3y) * pow(tt, 3));
    return new PVector (xx, yy);
  }
}
