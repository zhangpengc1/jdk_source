package com.marton.base.num;

class Foo {

    int i = 1;

    {
        i = 2;
    }

    Foo(){
        System.out.println(i);
        int x = getValue();
        System.out.println(x);
    }

    public int getValue(){
        return i;
    }
}

class Bar extends Foo{
    int j = 1;
    Bar(){
        j = 2;
    }



}
