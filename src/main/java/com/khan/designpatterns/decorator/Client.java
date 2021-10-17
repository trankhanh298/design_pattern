package com.khan.designpatterns.decorator;

import java.util.Date;

public class Client {

	private DateToString converter;
	
	public Client(DateToString converter) {
		this.converter = converter;
	}
	
	public void process(Date date) {
		String value = converter.convert(date);
		System.out.println("Convert value: " + value);
	}
}
