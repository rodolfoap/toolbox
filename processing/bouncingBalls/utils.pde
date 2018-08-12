float ballEnergy, totalEntropy, S;
void printStates(){
  float totalEnergy=0;
  totalEntropy=0;
  for(int k=0; k<balls.length; k++) {
    ballEnergy=balls[k].energy();
    totalEnergy+=ballEnergy;
    totalEntropy+=balls[k].entropy();
    print(balls[k].name+":["+ballEnergy+"/"+balls[k].initialEnergy+"] E="+balls[k].entropy()+"; ");
  }
  println(totalEnergy, "## S="+totalEntropy*1000);
}
