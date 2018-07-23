package org.rap.prgtests.patterns;

// An interface that defines a method
interface ICallback {
	void routine();
}

//An class implementing the interface
class Callback implements ICallback {
	@Override
	public void routine() {
		System.out.println("routineX");
	}
}

public class CallbackPattern {

	public static void main(String[] a) {

		// Creates a normal class
		Callback cbackX = new Callback();
		cbackX.routine();

		// Creates a class with a callback function
		Callback cbackY = new Callback() {
											@Override
											public void routine() {
												System.out.println("routineYYYY");
											}
										};
		cbackY.routine();
	}
}
