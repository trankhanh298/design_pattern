package com.khan.designpatterns.singleton;

public enum SingletonWithEnum {
	INSTANCE("khan");
	
	private String name;
	
	private SingletonWithEnum(String name) {
		this.name = name;
	}
	
	public void doSomething() {
		System.out.println(this.name + " does something");
	}
	
}
