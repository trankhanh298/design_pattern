package com.khan.designpatterns.strategy;

import org.junit.Test;

public class StrategyTest {
	
	@Test
	public void testStrategy() {
		// i want to have a duck cannot fly
		Duck duck = new Duck(new FlyNoWay());
		duck.fly();
		
		// now i want a duck can fly
		Duck mallardDuck = new Duck(new FlyWithWings());
		mallardDuck.fly();
	}

}
