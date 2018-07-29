void setup(){
  fullScreen();
  background(0);
  strokeWeight(1);
  translate(width/2, height/2);
  stroke(#111111);
  line(0, -height/2, 0, height/2);
  line(-width/2, 0, width/2, 0);
  stroke(#00FF00);
  noLoop();
}

// See the DRAW tab
