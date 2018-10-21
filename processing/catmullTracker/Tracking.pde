int t=0;
// First, assign probable matches (probabilities) to each detected point:
//        1-Determine the equation to describe the target position in function of time
//        Send the dealers matrix to each target, so each target detects its first, second, etc. by comparing them to all points: Kalman filter
//        e.g. target[1].match(d[7], 0.95); target[1].match[1]=match(d[4], 0.86); ...
//
// Second, assign points according to probabilities list.
//        Join all probabilities matrixes and process them in order:
//        0.95 - target[1] is d[7] 
//        0.92 - target[5] is d[3] 
//        0.86 - target[1] is d[4] 
//        0.72 - target[6] is d[4] // NOP: not possible, he's already assigned 
//        0.22 - target[4] is d[1] // NOP: not possible, too low. Kill target[4].
void doTracking() {
  for (int j=0; j<observ.length; j++) {
    println(j, int(observ[j].position.x), int(observ[j].position.y), ts, t);
  }
  t++;
}

/*
1.  If Time==0, assign matches directly
  a.  Create one T per O and assign last position
2.  If Time==1, F(T)=distance (T, O)
  a.  If T < O, add all new Ts as 1.a.
  b.  If T > O, nevermind, TO BE DISABLED.
3.  If Time>=1, F(T)=extrapolation (Tn, Tn-1, O)
  a.  If T < O, add all new Ts as 1.a.
  b.  If T > O, nevermind, TO BE DISABLED.
  c.  For each T, determine the probabilities to match each O using F(T)
T[1] matches can be: matchList<O, double> = 
[o[7], 0.95]; 
[o[4], 0.86]; 
…

4.  Merge the probabilities table, sort by probability and assign: 
[T[1], d[7], 0.95]; ok
[T[5], d[2], 0.92]; ok
[T[3], d[4], 0.86]; ok
[T[6], d[4], 0.72]; NO : d[4] is already assigned
[T[5], d[1], 0.22]; NO: T[5] is already assigned
*/
