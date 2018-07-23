package org.rap.prgtests.scripts.gtz;

public class Gtz04_Objetos_Obj2 {

	protected String nombre; 

// Ejemplo de sobrecarga de métodos, en este caso del constructor... ¿cuál usará java?

	public Gtz04_Objetos_Obj2() {			// constructor sin parámetros (además es necesario cuando el objeto es fértil)
		nombre = "Objeto 2"; 
	}

	public Gtz04_Objetos_Obj2(String n) {		// constructor paramétrico (constructor específico para este objeto)
		nombre = n;
	}
	
//	Resto de declaraciones, en este cado, un método

	public void verNombre(){
		System.out.println("Mi nombre es " + nombre);
	}

}
