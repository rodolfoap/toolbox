package org.rap.prgtests.twentyone;

import java.rmi.*;

interface PiRemote extends Remote {
    double getPi() throws RemoteException;
}

