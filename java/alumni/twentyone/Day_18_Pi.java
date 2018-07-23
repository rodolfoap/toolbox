package org.rap.prgtests.twentyone;

import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Day_18_Pi extends UnicastRemoteObject
    implements PiRemote {

    public double getPi() throws RemoteException {
        return Math.PI;
    }

    public Day_18_Pi() throws RemoteException {
    }

    public static void main(String[] arguments) {
        System.setSecurityManager(new
            RMISecurityManager());
        try {
            Day_18_Pi p = new Day_18_Pi();
            Naming.bind("//Default:1010/Pi", p);
        } catch (Exception e) {
            System.out.println("Error -- " +
                e.toString());
                e.printStackTrace();
        }
    }
}

