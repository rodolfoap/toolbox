package org.rap.prgtests;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	public static void main(String[] args) {
		List<Number> n=new ArrayList<Number> ();
		//List<? extends Number> n=new ArrayList<Number> ();
		//List<? super Number> n=new ArrayList<Number> ();
		//List<?> n=new ArrayList<Number>();
		n.add(new Integer(4));
		Number n2=n.get(0);
		System.out.println(n2);
	}
}
