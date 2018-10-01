/**
 * 
 */
package org.ydor.graphclient;

import processing.core.PApplet;

/**
 * @author RodolfoAP
 *
 */
public class Main extends PApplet {
	float thickness = 200;

	/**
	 * 
	 */
	public Main() {
		// Nothing to do here...
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("org.ydor.graphclient.Main");
	}

	/**
	 * @param x
	 * @param y
	 */
	void fn(float x, float y) {
		float d = radians(sqrt(pow(x, 2) + pow(y, 2)) * 2);
		stroke(0, 255 - 6 * PI * d, 6 * PI * d, 255 - 6 * PI * d);
		point(x, y, -cos(d) / d * thickness);
	}

	@Override
	public void draw() {
		//super.draw();
		background(0);
		stroke(color(0, 255, 0));
		translate(width / 2, height / 2 - 100, thickness);
		rotateX(radians(-mouseY - height / 2));
		rotateZ(radians(0));
		rotateY(radians(mouseX - width / 2));
		for (float x = -400; x < 400; x += 1) {
			for (float y = -400; y < 400; y += 1) {
				fn(x, y);
			}
		}
	}

	@Override
	public void mousePressed() {
		super.mousePressed();
		save("curve.png");
		noLoop();
	}

	@Override
	public void settings() {
		super.settings();
		fullScreen(P3D);
		noSmooth();
	}

	@Override
	public void setup() {
		super.setup();
		noFill();
		noCursor();
	}
}
