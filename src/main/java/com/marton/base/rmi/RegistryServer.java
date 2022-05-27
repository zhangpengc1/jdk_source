package com.marton.base.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

public class RegistryServer {

    public static void main(String[] args) throws RemoteException, InterruptedException {
        LocateRegistry.createRegistry(8000);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

}
