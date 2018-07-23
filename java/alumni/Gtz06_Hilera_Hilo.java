package org.rap.prgtests.scripts.gtz;

public class Gtz06_Hilera_Hilo extends Thread {
		String nombre;
		
		public Gtz06_Hilera_Hilo(String n) {
			nombre = n;
		}
		
		public void run() {
				for (int cont = 0; cont < 1000; cont++)
				System.out.print(nombre + cont + " ");
		}
}

