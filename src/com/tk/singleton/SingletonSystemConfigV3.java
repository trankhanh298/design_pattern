package com.tk.singleton;

/**
 * Almost the same with v2 solution
 * Instance will be created when this enum loaded by classloader
 * Also has problem with multiple classloader
 */
public enum SingletonSystemConfigV3 {
    INSTANCE;
}
