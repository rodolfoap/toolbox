float ballEnergy, totalEntropy, S;
void printStates() {
	float totalEnergy = 0;
	totalEntropy = 0;
        for (int k = 0; k < balls.length; k++) {
                totalEnergy += balls[k].energy();
                print("[" + balls[k].name + ": " + nf(balls[k].energy(), 2, 3)+"] ");
        }
        println();
        for (int k = 0; k < balls.length; k++) {
                totalEntropy += balls[k].entropy();
                print("[" + balls[k].name + ": " + nf(balls[k].entropy(), 2, 3)+"] ");
        }
	println("\nT: E=" + totalEnergy, ", S=" + totalEntropy+"\n");
}
