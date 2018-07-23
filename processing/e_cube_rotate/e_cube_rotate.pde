float x=0, y=0, z=0, limit=240;
float dx=1, dy=1, dz=1;
void setup() {
        fullScreen(P3D);	// Fullscreen canvas
        background(#000000);	// Background color
        stroke(#00FF00);	// Foreground color
        sphereDetail(16);	// Detail
	noFill();		// Foreground fill
}

void draw() {
        background(#000000);        // Background color
        translate(width/2, height/2, -300);
        rotateX(radians(-mouseY));
        rotateY(radians(mouseX));
        noFill();                // Foreground fill
        box(600);
        box(601);
        pushMatrix();
        x+=dx; y+=dy; z+=dz;
        if(x > limit) {dx=-random(1,28);}
        if(y > limit) {dy=-random(1,28);}
        if(z > limit) {dz=-random(1,28);}
        if(x <-limit) {dx= random(1,28);}
        if(y <-limit) {dy= random(1,28);}
        if(z <-limit) {dz= random(1,28);}
        translate(x, y, z);
        fill(#444444, 128);
	sphere(60);
        popMatrix();
}
