package org.rap.prgtests.scripts.gtz;

import java.awt.Point;

class Gtz09_SubPunto_SubPunto extends Point {
    String name;

    Gtz09_SubPunto_SubPunto(int x, int y, String name) {
        super(x,y);
        this.name = name;
    }

    public static void main (String[] arguments) {
    	System.out.println("Creando un nuevo punto...");
    	Gtz09_SubPunto_SubPunto np = new Gtz09_SubPunto_SubPunto(5, 5, "Pun Tito");
    	System.out.println("Punto creado. Datos:");
        System.out.println("\t     x: " + np.x);
        System.out.println("\t     y: " + np.y);
        System.out.println("\tNombre: " + np.name);
    }
}