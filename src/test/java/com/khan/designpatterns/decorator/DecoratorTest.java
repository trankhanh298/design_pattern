package com.khan.designpatterns.decorator;

import java.util.Date;

import org.junit.Test;

public class DecoratorTest {
	
	@Test
	public void testDecorator() {
		// first client want to format with iso-8601
		DateToString converter = new OriginalDateToStringConverter();
		Client client1 = new Client(converter);
		client1.process(new Date());
		
		// imagine the OriginalDateToStringConverter comes from a external jar which we can't change
		// we have the object created from this jar, does the original logic
		// but we want to extend logic little bit here that receives a date without time (hh:MM:ss)
		converter =  new DecoratedDateToStringConverter(converter);
		Client client2 = new Client(converter);
		client2.process(new Date());
	}
}
