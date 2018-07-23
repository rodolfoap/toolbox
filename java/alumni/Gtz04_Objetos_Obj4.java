package org.rap.prgtests.scripts.gtz;

public class Gtz04_Objetos_Obj4 extends Gtz04_Objetos_Obj2 {

	public Gtz04_Objetos_Obj4(String n) {
		nombre = n; 
	} 

	public void verNombre(){
		System.out.println("Mon nom est l'" + nombre);
	}

	public void verNombre2(){
		super.verNombre();
	}
}