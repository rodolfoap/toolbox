/**
 * 
 */
package org.rap.prgtests.patterns;

import java.util.UUID;

/**
 * @author RodolfoAP
 */
public class FactoryPattern
{
    class Manufactured
    {
        public String code = UUID.randomUUID().toString();


        public Manufactured(String name)
        {
            if (name != null)
            {
                this.code = name;
            }
            // TODO Auto-generated constructor stub
        }

        public void printCode()
        {
            System.err.println(this.code);
        }
    }


    /**
     * 
     */
    public FactoryPattern()
    {
        Manufactured m1 = this.getManufactured(null);
        Manufactured m2 = this.getManufactured("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");

        m1.printCode();
        m2.printCode();
    }

    private Manufactured getManufactured(String name)
    {
        return new Manufactured(name);
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        new FactoryPattern();
    }

}
