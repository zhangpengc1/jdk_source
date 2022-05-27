package com.marton.base.proxy.jdk;

public class UserServiceImpl implements UserService {

    @Override
    public int addUser(String name) {

        System.out.println("user insert successful name = " + name);

        getUser("inner");

        return 1;
    }

    @Override
    public int getUser(String name) {

        System.out.println("get user name = " + name);

        return 0;
    }


}
