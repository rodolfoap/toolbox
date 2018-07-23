/**
 * 
 */
package org.rap.prgtests;

/**
 * @author RodolfoAP
 *
 */
public class HelloWorld {

	/**
	 * 
	 */
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		System.err.println(new Throwable().getStackTrace()[0].toString()); /* RODOLFO */
	}
}
