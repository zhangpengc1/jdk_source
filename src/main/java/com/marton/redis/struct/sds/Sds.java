package com.marton.redis.struct.sds;


/**
 * @author ：zhangp
 * @Date ：2022/2/19 下午10:42
 */
public class Sds {

    private int len;

    private int free;

    private char[] buf;

    public static void main(String[] args) {


        String hello = new String("je;;;p");
        System.out.println(hello.toString());

        hello = "sssss";

        System.out.println(hello.hashCode());

    }


}
