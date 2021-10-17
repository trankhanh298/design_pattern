package com.khan.designpatterns.decorator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OriginalDateToStringConverter implements DateToString {

	private static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	public OriginalDateToStringConverter() {
	}
	
	public String convert(Date date) {
		SimpleDateFormat formater = new SimpleDateFormat(ISO_8601_PATTERN);
		return formater.format(date);
	}
}
