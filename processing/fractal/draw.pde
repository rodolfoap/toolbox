void drawFractal(float x1, float y1, float angle, float len){
        if(len>1){
	        float x2=x1+(len*cos(radians(angle)));
	        float y2=y1+(len*sin(radians(angle)));
		strokeWeight(len/50);
		stroke(color(0, 255, 0, (len-1)*9));
	        line(x1, y1, x2, y2);
                drawFractal(x2, y2, angle-40, len*0.73);
                drawFractal(x2, y2, angle+25, len*0.78);
	}
}
void draw(){
        drawFractal(width/2, height, -90, height/4);
	save("fractal.png");
	println("Done.");
}
//void mouseMoved() {
//	redraw();
//}
