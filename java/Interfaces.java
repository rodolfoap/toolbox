package org.rap.prgtests;

public class Interfaces implements InterfacesInterface {
	public void faces() {
		System.out.println("Hello, world!");
	}
	public static void main(String args[]) {
		Interfaces I=new Interfaces();
		I.faces();
	}
}
