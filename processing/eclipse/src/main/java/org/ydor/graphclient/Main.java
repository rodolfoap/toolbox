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
		PApplet.main("org.ydor.graphclient.graphclient.Main");
	}

	@Override
	public void draw() {
		super.draw();
		ellipse(width / 2, height / 2, second(), second());
	}

	@Override
	public void mousePressed() {
		super.mousePressed();
	}

	@Override
	public void settings() {
		super.settings();
		size(300, 300);
	}

	@Override
	public void setup() {
		super.setup();
		fill(120, 50, 240);
	}
}
