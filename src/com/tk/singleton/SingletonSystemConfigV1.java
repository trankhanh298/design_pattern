package com.tk.singleton;

/**
 * Singleton with synchronized.
 * Instance will be created on demand -> better than v2 with static block
 * Will be crack by using different classloaders
 */
public class SingletonSystemConfigV1 {

    private static SingletonSystemConfigV1 instance;

    private SingletonSystemConfigV1() {
    }

    public static synchronized SingletonSystemConfigV1 getInstance() {
        if (instance == null) {
            instance = new SingletonSystemConfigV1();
        }
        return instance;
    }

    public Object clone() {
        // don't need to check null, because we are cloning from an existing object
        // at this time, we expect instance had to be created
        return instance;
    }
}
