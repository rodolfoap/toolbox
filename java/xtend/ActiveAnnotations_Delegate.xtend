package org.rap.prgtests.xtend
import org.eclipse.xtend.lib.annotations.Delegate

// This is the interface
interface Language { def void greeting() }

// It can be implemented in two forms 
class English implements Language { override greeting() { println("Hello!") } }
class French  implements Language { override greeting() { println("Salut!") } }

// So the class speaker...
class Speaker implements Language {

	// Will delegate french implementations in this case...
	@Delegate 
	Language myDelegate = new French
	// And use any...
	new(){ greeting() }
	
	/* Because here, Xpect generates this:
	 * public void greeting() { this.myDelegate.greeting(); }
	 */
}

// This just starts the code -------------------------------
class ActiveAnnotations_Delegate {
	def static void main(String[] s){
		new Speaker 
	}
}
