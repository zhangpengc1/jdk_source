package com.marton.base.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRemote extends Remote {

    String sayHello(String name) throws RemoteException;

}
