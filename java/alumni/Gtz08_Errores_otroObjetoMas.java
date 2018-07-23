package org.rap.prgtests.scripts.gtz;

public class Gtz08_Errores_otroObjetoMas {

	public Gtz08_Errores_otroObjetoMas () throws Gtz08_Errores_MiError {
		int[] arreglo = new int[5];
		int cont;

		for(cont=1;cont<=5;cont++) {
			if(cont!=arreglo.length)
				arreglo[cont]=10 - cont;
			else
				throw new Gtz08_Errores_MiError("El subíndice excede los límites permitidos. Se recomienda tomar unas lecciones intensivas de Java."); 
		}
	}
}