package org.rap.prgtests.scripts.gtz;

public class Gtz08_Errores_Errores {

public static void main(String args[]) {
	
	try {
		System.out.println("Ejecutada instrucción de intento de acción con posibilidad de error...");
		Gtz08_Errores_otroObjeto otro1 = new Gtz08_Errores_otroObjeto();
	}  

	catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Atrapada excepción de índice fuera de límites. \n Mensaje del sistema Java:\n " + e.getMessage());
	}
	finally { 
		System.out.println("Ejecutada instrucción alternativa en caso de error...\n\n");
	}  
		
	try {
		System.out.println("Ejecutada instrucción de intento de acción con posibilidad de error...");
		Gtz08_Errores_otroObjetoMas otro2 = new Gtz08_Errores_otroObjetoMas();
	}  
	catch (Gtz08_Errores_MiError e) {
		System.out.println("Atrapada excepción generada por vuestra merced. \n Mensaje del sistema Ya-va:\n " + e.getMessage());
	}
	finally { 
		System.out.println("Ejecutada instrucción alternativa en caso de error...\n\n");
	}  
	
}
}
