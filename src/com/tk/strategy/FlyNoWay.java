package com.tk.strategy;

public class FlyNoWay implements  FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm rubble duck, i cannot fly");
    }
}
