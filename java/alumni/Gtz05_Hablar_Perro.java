package org.rap.prgtests.scripts.gtz;

public class Gtz05_Hablar_Perro extends Gtz05_Hablar_Mamifero{

	public Gtz05_Hablar_Perro(String texto){
		Nombre = texto;
	}

	public void speak(){
		System.out.println("    Guau, guau...");
	}

}