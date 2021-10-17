package com.khan.designpatterns.singleton;

public class SingletonWithStaticBlock {

	private static SingletonWithStaticBlock instance;

    static {
        instance = new SingletonWithStaticBlock();
    }

    public static SingletonWithStaticBlock getInstance() {
        return instance;
    }

    @Override
    public Object clone() {
        return instance;
    }
}
