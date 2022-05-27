package com.marton.base.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRemoteImpl extends UnicastRemoteObject implements HelloRemote {

    protected HelloRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "say hello to " + name;
    }
}
