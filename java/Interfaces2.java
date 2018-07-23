package org.rap.prgtests;

interface Model2 {
	public void SayHi();
	public void SayBye();
}
public class Interfaces2 implements Model2 {
	public static void main(String args[]) {
		Interfaces2 i2=new Interfaces2();
		i2.SayHi();
		i2.SayBye();
	}
	public void SayHi(){
		System.out.println("Hello, world!");
	}
	public void SayBye(){
		System.out.println("Hello, world!");
	}
}
