package com.khan.designpatterns.strategy;

public class Duck {
    private FlyBehavior flyBehavior;

    public Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void fly() {
        this.flyBehavior.fly();
    }
}