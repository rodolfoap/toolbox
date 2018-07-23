package org.rap.prgtests;

import java.util.ArrayList;
import java.util.List;

/* Wikipedia: The observer pattern is a software design pattern in which an object, 
 * called the subject[SYSLOG], maintains a list of its dependents[MyClient], called observers, 
 * and notifies them automatically of any state changes, 
 * usually by calling one of their methods[doSomething]. 
 * */

/* 1) Una clase Syslog puede declarar una lista de listeners, proveyendo una interface (los clientes deben implementar eso)
 *    Ahi disparamos la accion a los clientes. O sea, que cada que haya un log, Syslog puede disparar una accion en 
 *    los clientes que implementen la interfaz 
 *     
 * 2) La clase MyClient (que sera notificada) debe implementar los listeners.
 * 
 * 3) En tiempo de ejecucion, al enviar un comando log(), el metodo log() acciona los listeners. Simple.
 *
 * O sea, SOMEBODY_LOGS-->SYSLOG-->MyClient
 */

// Este es el trigger, el que registra los listeners registrados, formalmente el "subject" 
class Syslog {
	// (1) Tengo una lista de listeners y una interfaz que me dice como implementar los listeners
	public static List<Listener> listeners = new ArrayList<>();
	public static interface Listener { public void doSomething(String msg); }

	// Luego, mis metodos normales
	public static void log(String message) {
		System.out.println("LOG: "+message);
		// No olvidar: Disparar la accion a los clientes
		for (Listener listener : listeners) { listener.doSomething(message); }
	}
}

// Esta clase es el cliente de Syslog, formalmente el "Observer"
class MyClient implements Syslog.Listener {
	@Override
	// (2) Implementamos los métodos de los listeners
	public void doSomething(String msg) {
		System.err.println(new Throwable().getStackTrace()[0].toString()+"|msg="+msg); /* RODOLFO */
	}
}

// Ahora, mi ejecucion: (ejecutar varias veces, el resultado puede ser diferente, pues usa threads)
public class Listeners {
	public static void main(String[] s) {
		// Crear el objeto (MyListener)log
		MyClient logAnalyzer = new MyClient();
		// y usarlo como listener de Syslog
		Syslog.listeners.add(logAnalyzer);

		//	Luego, trabajamos normalmente
		Syslog.log("Hello, World!");
		Syslog.log("Hello again, World!");

		// Retirarlo de listeners
		Syslog.listeners.remove(logAnalyzer);
	}
}