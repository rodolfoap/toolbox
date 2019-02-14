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
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String sayHello() {
		return "Hello, " + name + "!";
	}

	/**
	 * Trivial Greeter class
	 */
	public String getName() {
		return this.name;
	}
}
