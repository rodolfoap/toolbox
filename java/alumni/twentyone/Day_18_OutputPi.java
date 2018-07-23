package org.rap.prgtests.twentyone;

import java.rmi.*;
import java.rmi.registry.*;

public class Day_18_OutputPi {
    public static void main(String[] arguments) {
        System.setSecurityManager(
            new RMISecurityManager());
        try {
            PiRemote pr =
                (PiRemote)Naming.lookup(
                    "//Default:1010/Pi");
            for (int i = 0; i < 10; i++)
                System.out.println("Pi = " + pr.getPi());
        } catch (Exception e) {
            System.out.println("Error -- " + e.toString());
            e.printStackTrace();
        }
    }
}
