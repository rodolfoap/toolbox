package ydor.org.javabuildchain;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GreeterTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public GreeterTest(String testName) {
		super(testName);
		System.err.println(new Throwable().getStackTrace()[0].toString());
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		return new TestSuite(GreeterTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		System.err.println(new Throwable().getStackTrace()[0].toString());
		Greeter greeter = new Greeter("World");
		assertEquals("World", greeter.getName());
	}
}
