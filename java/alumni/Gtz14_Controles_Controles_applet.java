package org.rap.prgtests.scripts.gtz;

import java.awt.*;

public class Gtz14_Controles_Controles_applet extends java.applet.Applet {

    Button enverresar; 
    TextField nombre, verres;

	// métodos de applets:
	// init() llama a start(), el que interactua con stop(). 
	// paint() actúa periodicamente y 
	// final ocurre destroy().

    public void init() {
        setBackground(Color.white); 
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        nombre = new TextField("Mal si le das la fe falsa del islam");
	  add(nombre);
        verres = new TextField("                          ");
	  add(verres);
        enverresar = new Button("Verrés");
        add(enverresar);
    }

    public boolean action(Event evt, Object arg) { 
        if (evt.target instanceof Button) { 
            accionBoton((Button)evt.target); 
            return true; 
        } 
        else return false; 
    } 

    void accionBoton(Button b) { 
 
 	    String txtDerech = nombre.getText();
	    String txtVerres = "";
	    String txtLetra = "";
	    int c;
	    if (b == enverresar) {
		     for(c=0;c<txtDerech.length();c++){
		     		txtLetra = txtDerech.substring(c,c+1);
		     		txtVerres = txtLetra + txtVerres;
            }
	    verres.setText(txtVerres);
	    repaint(); 
	    }
    }
}
