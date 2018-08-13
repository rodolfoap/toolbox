float ballEnergy, totalEntropy, S;
void printStates(){
  float totalEnergy=0;
  totalEntropy=0;
  for(int k=0; k<balls.length; k++) {
    ballEnergy=balls[k].energy();
    totalEnergy+=ballEnergy;
    totalEntropy+=balls[k].entropy;
    //print(balls[k].name+":[E="+balls[k].energy()+", S="+balls[k].entropy+"]; ");
    print(balls[k].name+":["+balls[k].entropy+"]; ");
  }
  println("\nT: E="+totalEnergy, ", S="+totalEntropy);
}
