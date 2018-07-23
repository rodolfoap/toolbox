float angle=0, x=0, y=0;

void linePolar(float rotate, float length){
        angle+=radians(rotate);
        float px=x+length*cos(angle);
        float py=y+length*sin(angle);
	//println("x=", x, "; y=", y, "; px=", px, "; py=", py, "; angle=", angle);
	line(x, y, px, py);
	x=px; y=py;
}

void setup() {
	fullScreen();			// Fullscreen canvas
	background(#000000);		// Background color
	stroke(#00FF00);		// Foreground color
	noFill();			// Foreground fill
	noSmooth();			// Avoids antialiasing
	noLoop();			// Avoid looping the draw() function
        point(x, y);
        noLoop();                        // Avoid looping the draw() function
}

void draw() {
	linePolar(0, 600);
	for(float len=600; len>0; len-=2){
		linePolar(90.2, len);
	}
	save("flower.png");
}
