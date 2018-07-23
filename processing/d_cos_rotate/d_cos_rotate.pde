float fn(float x, float y){
        float d=radians(sqrt(pow(x-300,2)+pow(y-300,2))*2);
        return -cos(d)/d*80.0;
//      return -sin(d)/d*100.0;
}
void setup() {
        fullScreen(P3D);	// Fullscreen canvas
        background(#000000);	// Background color
        stroke(#00FF00);	// Foreground color
        noFill();		// Foreground fill
        noSmooth();		// Avoids antialiasing
        noLoop();		// Avoid looping the draw() function

        translate(400,50,0);
	rotateX(radians(45));
        rotateZ(radians(-5));
        rotateY(radians(+5));

        for(float x=0; x<600; x+=2){
	        for(float y=0; y<600; y+=2){
        		point(x,y,fn(x,y));
	        }
        }

}
