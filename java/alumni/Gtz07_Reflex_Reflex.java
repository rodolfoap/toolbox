package org.rap.prgtests.scripts.gtz;

import java.lang.reflect.*;
import java.util.Random;

class Gtz07_Reflex_Reflex {
    public static void main(String[] arguments)  { 
    
        String rd = new String(); 
        Class clase = rd.getClass(); 
        
        Method[] metodos = clase.getMethods(); 
        for (int i = 0; i < metodos.length; i++) { 
            System.out.println("Método: " + metodos[i]); 
        }

        Field[] campos = clase.getFields(); 
        for (int i = 0; i < campos.length; i++) { 
            System.out.println("Campo: " + campos[i]); 
        }

        Constructor[] constructores = clase.getConstructors(); 
        for (int i = 0; i < constructores.length; i++) { 
            System.out.println("Constructor: " + constructores[i]); 
        }
    }
}

