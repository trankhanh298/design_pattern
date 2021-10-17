package com.khan.designpatterns.strategy;

public class FlyNoWay implements FlyBehavior {

	public void fly() {
		System.out.println("I'm rubble duck, i cannot fly");
	}

}
