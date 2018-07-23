package org.rap.prgtests.scripts.gtz;

public class Gtz04_Objetos_Obj3 extends Gtz04_Objetos_Obj2 {  // este objeto heredará las características del objeto 2

	public Gtz04_Objetos_Obj3(String n) {
		nombre = n; 			// el campo nombre es heredado de la clase Obj2
	} 
	
	// no existe la declaración verNombre(), pero funciona, pues la hereda del objeto Obj2
	
}