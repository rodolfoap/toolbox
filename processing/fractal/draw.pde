void drawFractal(float x1, float y1, float angle, float len){
        if(len>2){
	        float x2=x1+(len*cos(radians(angle)));
	        float y2=y1+(len*sin(radians(angle)));
		//strokeWeight(1+len/100);
	        line(x1, y1, x2, y2);
                drawFractal(x2, y2, angle-10, len*0.70);
                drawFractal(x2, y2, angle+15, len*0.75);
	}
}
void draw(){
        drawFractal(width/2, height, -90, height/4);
}
void mouseMoved() {
	redraw();
}
