package org.rap.prgtests.scripts.gtz;

public class Gtz05_Hablar_Mamifero {

	protected String Nombre;
	
	public Gtz05_Hablar_Mamifero(){
	}
	
	public Gtz05_Hablar_Mamifero(String texto){
		Nombre = texto;
	}

	public void sleep(){
		System.out.println("    Ronc, groar, pffffssss, ronc, ronc... grrrr..... uffff..... ");
	}
	
	public String verNombre(){
		return(Nombre);
	}

}