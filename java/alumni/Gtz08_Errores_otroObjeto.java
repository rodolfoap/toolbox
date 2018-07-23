package org.rap.prgtests.scripts.gtz;

public class Gtz08_Errores_otroObjeto {

	public Gtz08_Errores_otroObjeto () {
		int[] arreglo = new int[5];
		int cont;

		for(cont=1;cont<=5;cont++) {
				arreglo[cont]=10 - cont;
		}
	}
}