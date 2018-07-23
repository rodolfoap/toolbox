package org.rap.prgtests;

import java.lang.reflect.Field;
import java.util.Random;

public class SetAccessible {
	public static void main(String[] s) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MyClass myClass = new MyClass();
        Field field1 = myClass.getClass().getDeclaredField("theField");
        Field field2 = myClass.getClass().getDeclaredField("theField");

        field1.setAccessible(true); // Only changes the behavior of the *field1* variable, not the class.

        System.out.println("Outside: field1.theField="+field1.get(myClass)); // What??? I can read it!!!
        System.out.println("Outside: field2.theField="+field2.get(myClass)); // Throws ERROR: field2 is not accessible
	}
}
class MyClass {
	private int theField; // Shouldn't be accessible...
	public MyClass(){
    	Random rn = new Random();
    	theField=rn.nextInt(100)+1;
    	System.out.println("Constructor: theField="+theField);
    }
}
