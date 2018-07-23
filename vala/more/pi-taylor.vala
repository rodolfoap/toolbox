public static void main() {
	stdout.printf("pi=4 * (1 -1/3 + 1/5 -1/7 +1/9 -1/11 +1/13 -1/15 ...)\n\n");
	stdout.printf("Printing every 100 million loops...\n");
	uint64 denom=1;
	int sign=1;
	double pi=0;
	uint prflag=100000000;
	while(true){
		pi+=(double)4 * sign / denom;
		denom+=2;
		sign*=-1;
		prflag--;
		if(prflag<2) {
			prflag=100000000;
			stdout.printf("pi=%s\n", pi.to_string());
		}
	}
}
