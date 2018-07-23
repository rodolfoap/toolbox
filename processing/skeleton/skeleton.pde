void setup() {
	fullScreen();			// Fullscreen canvas
//	size(400, 400);			// Windowed canvas
	background(#000000);		// Background color
	stroke(#00FF00);		// Foreground color
	fill(#444444);			// Foreground fill
	noSmooth();			// Avoids antialiasing
//	noLoop();			// Avoid looping the draw() function

        ellipse(width/4, height/4, 100, 100);
        noFill();
        ellipse(width/4+25, height/4+25, 100, 100);
        rect(0, 0, width-1, height-1, 5);

        point(30, 20);
        point(85, 20);
        point(85, 75);
        point(30, 75);
}

void draw() {
        line(width/2, height/2, mouseX, mouseY);
}
