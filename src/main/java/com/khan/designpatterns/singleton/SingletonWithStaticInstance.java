package com.khan.designpatterns.singleton;

public class SingletonWithStaticInstance {

	private static SingletonWithStaticInstance instance;

    private SingletonWithStaticInstance() {}

    public synchronized static SingletonWithStaticInstance getInstance() {
        if (instance == null) {
            instance = new SingletonWithStaticInstance();
        }
        return instance;
    }

    @Override
    public Object clone() {
        return instance;
    }
}
