package org.rap.prgtests;

public class Getenv {

	public static void main(String[] args) {
		String a=System.getenv("JAVA_HOME");
		System.out.println(a);
	}

}
