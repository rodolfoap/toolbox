float thickness=200.0;
void fn(float x, float y){
        float d=radians(sqrt(pow(x,2)+pow(y,2))*2);
	stroke(0, 255-6*PI*d, 6*PI*d, 255-6*PI*d);
	point(x, y, -cos(d)/d*thickness);
//	point(x, y, -sin(d)/d*thickness);
}
void setup() {
        fullScreen(P3D);	// Fullscreen canvas
        noFill();		// Foreground fill
        noSmooth();		// Avoids antialiasing
	noCursor();		// Hides mouse cursor
}
void draw(){
        background(#000000);        // Background color
        stroke(#00FF00);        // Foreground color
        translate(width/2, height/2 -100, thickness);
        rotateX(radians(-mouseY-height/2));
        rotateZ(radians(0));
        rotateY(radians(mouseX-width/2));

        for(float x=-400; x<400; x+=1){
                for(float y=-400; y<400; y+=1){
                        fn(x, y);
                }
        }
}
void mouseClicked(){
	save("curve.png");
}
