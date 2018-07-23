package org.rap.prgtests.scripts.gtz;

import java.lang.String;

public class Gtz02_Monstruo_Monstruo {
	
	public static void main(String args[]){

		// Esta es la historia de la vida del monstruo
		
		/* 
		"En qué interno lugar, en qué caverna
		del centro obscuro he yo vivido oculto,
		que ignoro el ser que me acompaña y rige?
		¡Cielos! ¿Quién soy? ¿Quién me gobierna y manda?

		(Lope de Vega, El Antecristo)
		*/

		// tipos primitivos
		int cnt;					// variable sin inicializar
		short pies = 9;					// variable ya inicializada
		byte b = 13;
		float pi = (float) 3.14159265358989;		// casting explícito
		double dedos = 983;
		char k='t';
		boolean CIERTO = true;
		boolean FALSO = false;

		String nombre = "Polifeo " + 2 + "do.";	// casting implícito
				
		// Ejemplos de uso de variables y objetos
		String 	apellido;
		apellido="El Profugo Feo ";
		String	t2= "desde Java"; 
		
		// Objetos
		String 	t3 = new String("hasta el Padep");
		String[] familia = new String[5];
		String[][] historia = new String[5][2];
		String apodo1 = nombre.replace('P','C') ;
		String apodo2 = nombre.substring(0,6) + k + nombre.substring(6);
		
		//Ejemplos salida consola
		System.out.print("Mi nombre es " + nombre + ", " + apellido + "(no me confundáis con Polifemo, esa es mi suegra). ");
		System.out.println("Me escapé " + t2 + " " + t3 + ".\nTengo " + (int)dedos + " dedos en cada pata, es decir, " 
			+ (int)(dedos*pies) + " dedos en total.\nPero el otro día me comí 3 al cortarme las uñas...");
		System.out.println("En el componente 3, el peor que puede haber, lleno de monstruos y otros fenómenos, me decían " 
			+ apodo1 + " y " + apodo2);

		System.out.print("Tu eres un descarado. Me dijiste " + args.length + " cosas: ");
		for(cnt=0;cnt<args.length;cnt++)
			System.out.print("me dijiste que soy un " + args[cnt] + "; " );
			System.out.println("... todo eso me dijiste. Buaaa!!! ");

		// ejemplos de operadores, como ==, !=, <>, etc...
		if(args.length==1) { 
			System.out.println("Al menos me pusiste sólo un apodo.");
		}
		else
			System.out.print("Eres un desgraciado... ");

		System.out.println((args.length==2)==CIERTO?"dos insultos... como el número de ojos que te voy a sacar...":"en fin...");

		switch(args.length) {
			case 0:
				System.out.println("Te voy a contar algunas cosas.");
				break;
			case 1:
				System.out.println("Y tú eres un desorganizado.");
				break;
			case 2:
				System.out.println("Y tú eres un desorganizado y malpensado.");
				break;
			case 3:
				System.out.println("Y tv eres un desorganizado, gavil�n y malpensado.");
				break;
			default:
				System.out.println(/*¡¡¡qué miedo!!!*/"Sabes, por esta vez te perdono.");
				break;
		}
		
		familia[0]="Rupert"; 
		familia[1]="Astrid"; 
		familia[2]="Helga"; 
		familia[3]="Cornelius";
		familia[4]="Hagrid"; 

		cnt=0; 
		System.out.print("Esta es mi familia: "); 
		do { 
			System.out.print(familia[cnt] + (cnt==familia.length-1?". ":", ") ); 
			historia[cnt][0]=familia[cnt] + " trabaja "; 
			switch(cnt) { 
				case 0: historia[cnt][1]="asustando a princesas hermosas e inocentes"; break; 
				case 1: historia[cnt][1]="comiéndose a indefensos mancebos"; break;
				case 2: historia[cnt][1]="durmiendo todo el día y comiendo acelga"; break;
				case 3: historia[cnt][1]="cuidando a la fácil... digo... bueno... a su bella esposa"; break;
				case 4: historia[cnt][1]="como actor de películas baratas, con un tal Potter"; break;
			} 
			cnt++; 
		} 
		while (cnt<familia.length); 
		System.out.println(); 

		cnt=0; 
		while (cnt<familia.length){ 
			System.out.println(historia[cnt][0] + historia[cnt][1] + "." ); 
			cnt++;		 
		} 
		System.out.print("Un gusto. Cuando quieras cenamos. Yo pongo el vino y tu eres... er... tu traes la comida. \n\n"); 
	} 
} 
