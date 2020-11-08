package com.tk.singleton;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;


public class Main {

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(SingletonTest.class);
    }

}
