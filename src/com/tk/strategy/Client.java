package com.tk.strategy;

public class Client {

    private String name;

    Client(String name) {
        this.name = name;
    }

    public void makePetFly() {
        Duck rubbleDuck = new Duck(new FlyNoWay());
        rubbleDuck.fly();

        Duck mallardDuck = new Duck(new FlyWithWings());
        mallardDuck.fly();
    }
}
