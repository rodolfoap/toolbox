package org.rap.prgtests;

import java.lang.reflect.*;
public class Reflection {
	public String text;
	public static void main(String args[]) {
		Method[] methods = String.class.getDeclaredMethods();
		Field[]  fields  = String.class.getDeclaredFields();
		for(Method method : methods) System.out.println("method = " + method.getName()+"="+method.toString());
		for(Field  field  : fields ) System.out.println("field = " +   field.getName()+"="+field.toString());
	}
}
