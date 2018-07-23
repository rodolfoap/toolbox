package org.rap.prgtests.scripts.gtz;

public class Gtz04_Objetos_Objetos {

	public static void main(String args[]) {
	Gtz04_Objetos_Obj1 uno = new Gtz04_Objetos_Obj1();
	uno.verNombre();			// llamada estandar a método
	 
	Gtz04_Objetos_Obj2 dos = new Gtz04_Objetos_Obj2("Objeto 2");	// construcción paramétrica
	dos.verNombre();
	
	Gtz04_Objetos_Obj3 tre = new Gtz04_Objetos_Obj3("Objeto 3");	 // construcción paramétrica de un objeto hijo
	tre.verNombre();
	
	Gtz04_Objetos_Obj4 cua = new Gtz04_Objetos_Obj4("Objet quatre");
	cua.verNombre();			// otro tipo de verNombre()
	cua.verNombre2();			// otro tipo de verNombre()
	
	}

}
