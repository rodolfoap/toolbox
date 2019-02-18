/**
 * 
 */
package ydor.org.javabuildchain;

/**
 * @author rodolfoap
 *
 */
public class Greeter {
	private String name;

	/**
	 * Trivial Greeter class
	 */
	public Greeter(String name) {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String sayHello() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		return "Hello, " + name + "!";
	}

	/**
	 * Trivial Greeter class
	 */
	public String getName() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		return this.name;
	}
}
