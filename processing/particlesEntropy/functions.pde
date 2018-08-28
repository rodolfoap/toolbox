void calculateEntropy() {
        print("E: ");
        totalEnergy=0;
        for (int k = 0; k < balls.length; k++) {
                totalEnergy += balls[k].energy();
                print(balls[k].name + ":" + nfp(balls[k].energy(), 1, 2)+"; ");
        }
        print("TOTAL: " + nfp(totalEnergy, 1, 2)+"\nS: ");

      totalEntropy=0;
        for (int k = 0; k < balls.length; k++) {
                totalEntropy += balls[k].entropy();
                print(balls[k].name + ":" + nfp(balls[k].entropy(), 1, 2)+"; ");
        }
        // We use int() because this is a screen coordinate
        entropy[interaction]=int(totalEntropy);
	print("TOTAL: " + nfp(totalEntropy, 1, 2)+"\n\n");
}

void drawEntropy(){
  float entropyScale=0.001;
  stroke(color(0, 128, 128));
  lastX=0; lastY=height;
  for(int frame=0; frame<interaction; frame++){
    line(lastX, lastY, frame, height-(entropy[frame]*entropyScale+1));
    lastX=frame; lastY=int(height-(1 + entropy[frame]*entropyScale));
  }
}

void drawWall(){
  if(rWall<width) line(rWall, 0, rWall, height);
}
