package org.rap.prgtests;

import javax.swing.JFrame;

public class Jframe extends JFrame {

	public Jframe() {
		setTitle("Simple example");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		Jframe ex = new Jframe();
	}
}
