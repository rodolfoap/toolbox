package org.rap.prgtests.scripts.gtz;

public class Gtz05_Hablar_Hablar
{
	public static void main(String args[])
	{
		System.out.println("¡Tenemos dos nuevos amigos!");
		Gtz05_Hablar_Perro diogenes = new Gtz05_Hablar_Perro("Diógenes");
		Gtz05_Hablar_Persona linyera = new Gtz05_Hablar_Persona("Rodolfo");
		System.out.println("Vamos a conocerlos mejor.");
		System.out.println("El nombre del perrito es " + diogenes.verNombre());
		System.out.println("El nombre del caballero es " + linyera.verNombre());
		System.out.println("Ahora, por favor unas palabras de cada uno.");
		diogenes.speak();
		linyera.speak();
		System.out.println("Ahora, todos a hacer la siesta.");
		diogenes.sleep();
		linyera.sleep();
		System.out.println("De pronto, aparece un personaje misterioso...");
		Gtz05_Hablar_Mamifero animal = new Gtz05_Hablar_Mamifero("Mánimal");
		System.out.println("Su nombre es " + animal.verNombre());
		System.out.println("Pero lo único que sabe hacer es...");
		animal.sleep();
	}
}