package org.rap.prgtests.scripts.gtz;

public class Gtz06_Hilera_Hilera
{
	public static void main(String[] args) {
//		Gtz06_Hilera_Hilo_sin uno = new Gtz06_Hilera_Hilo_sin("A");
//		Gtz06_Hilera_Hilo_sin dos = new Gtz06_Hilera_Hilo_sin("B");
//		Gtz06_Hilera_Hilo_sin tre = new Gtz06_Hilera_Hilo_sin("C");
		Gtz06_Hilera_Hilo uno = new Gtz06_Hilera_Hilo("A");
		Gtz06_Hilera_Hilo dos = new Gtz06_Hilera_Hilo("B");
		Gtz06_Hilera_Hilo tre = new Gtz06_Hilera_Hilo("C");
		uno.start();
		dos.start();
		tre.start();
	}
}

