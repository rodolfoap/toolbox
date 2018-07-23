package org.rap.prgtests.patterns;

class PlutoStringConcatenationClient {}
class PlutoProcedure {}
class Master {
	public PlutoStringConcatenationClient foo(final PlutoProcedure e) {
	    return new PlutoStringConcatenationClient();
//	    return "";
	 }
}

public class Dummy {
	public static void main(String[] args) {
		PlutoProcedure proc=new PlutoProcedure();
		Master env=new Master();
		PlutoStringConcatenationClient x = env.foo(proc);
		System.out.println(x);
		//org.rap.prgtests.patterns.PlutoStringConcatenationClient@659e0bfd
	}
}