package com.marton.base.proxy;


import com.marton.base.proxy.jdk.UserService;
import com.marton.base.proxy.jdk.UserServiceImpl;
import com.marton.base.proxy.jdk.JDKCommonInvocationHandler;

public class JdkProxy {

    public static void main(String[] args) {

        JDKCommonInvocationHandler jdkCommonInvocationHandler = new JDKCommonInvocationHandler(new UserServiceImpl());


        UserService userService = (UserService)jdkCommonInvocationHandler.getProxy();

        System.out.println(userService.addUser("hehe"));
    }

}
