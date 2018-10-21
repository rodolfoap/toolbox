class Observ {
  PVector p0=new PVector(20, 220);
  PVector p1=new PVector(40, 240);
  PVector p2=new PVector(60, 260);
  PVector p3=new PVector(width/2, height/2);
  PVector position;
  int t = 0, name;
  float sections;
  boolean free=true;

  Observ(int n, float speed) {
    sections=0.75*width/speed;
    name=n;
  }

  void move() {  
    if (t>=sections) {   
      t=0;
      p0=p1.copy();
      p1=p2.copy();
      p2=p3.copy();
      p3=new PVector(random(width), random(height));
    }
    position = catmull(t/sections, p0.x, p0.y, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    t++;
  }

  void render() {  
    stroke(0, 255, 0);
    ellipse(int(position.x), int(position.y), 4, 4);
  }

  PVector catmull (float tt, float p0x, float p0y, float p1x, float p1y, float p2x, float p2y, float p3x, float p3y) {
    float xx = 0.5 * ((2*p1x) + (-p0x + p2x)*tt + (2*p0x - 5*p1x + 4*p2x -p3x) * pow(tt, 2) + (-p0x + 3*p1x - 3*p2x + p3x) * pow(tt, 3));
    float yy = 0.5 * ((2*p1y) + (-p0y + p2y)*tt + (2*p0y - 5*p1y + 4*p2y -p3y) * pow(tt, 2) + (-p0y + 3*p1y - 3*p2y + p3y) * pow(tt, 3));
    return new PVector (xx, yy);
  }
}
