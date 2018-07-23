package org.rap.prgtests.scripts.gtz;

public class Gtz06_Hilera_Hilo_sin {
		String nombre;
		
		public Gtz06_Hilera_Hilo_sin(String n) {
			nombre = n;
		}
		
		public void start() {
				for (int cont = 0; cont < 1000; cont++)
				System.out.print(nombre + cont + " ");
		}
}

