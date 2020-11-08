package com.tk.singleton;

/**
 * Singleton pattern with static block
 * Instance will be created when classloader load this class -> memory cost
 */
public class SingletonSystemConfigV2 {

    private static SingletonSystemConfigV2 instance;

    static {
        instance = new SingletonSystemConfigV2();
    }

    public static SingletonSystemConfigV2 getInstance() {
        return instance;
    }

    public Object clone() {
        // don't need to check null, because we are cloning from an existing object
        // at this time, we expect instance had to be created
        return instance;
    }
}
