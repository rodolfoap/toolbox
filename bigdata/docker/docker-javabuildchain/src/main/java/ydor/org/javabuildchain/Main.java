package ydor.org.javabuildchain;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		Greeter greeter = new Greeter("World");
		System.out.println(greeter.sayHello());
	}
}
