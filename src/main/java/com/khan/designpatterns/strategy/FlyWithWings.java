package com.khan.designpatterns.strategy;

public class FlyWithWings implements  FlyBehavior {

    public void fly() {
        System.out.println("I'm mallard, i can fly");
    }
}