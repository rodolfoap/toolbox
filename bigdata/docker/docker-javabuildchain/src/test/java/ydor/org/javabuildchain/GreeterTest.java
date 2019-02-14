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
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(GreeterTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Greeter greeter = new Greeter("World");
		assertEquals("World", greeter.getName());
	}
}
