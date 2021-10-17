package com.khan.designpatterns.decorator;

import java.util.Date;

public class DecoratedDateToStringConverter implements DateToString {

	private DateToString originalConverter;
	
	public DecoratedDateToStringConverter(DateToString originalConverter) {
		this.originalConverter = originalConverter;
	}

	public String convert(Date date) {
		String formatedString = originalConverter.convert(date);
		return formatedString.substring(0, 10);
	}
}
