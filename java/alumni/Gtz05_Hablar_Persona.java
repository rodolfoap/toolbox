package org.rap.prgtests.scripts.gtz;

public class Gtz05_Hablar_Persona extends Gtz05_Hablar_Mamifero {

	public Gtz05_Hablar_Persona(String texto) {
		Nombre=texto;
	}

	public void speak(){
		System.out.println("    ¿Quisiera conversar conmigo? Necesito alguien que me escuche y me entienda...");
	}


}