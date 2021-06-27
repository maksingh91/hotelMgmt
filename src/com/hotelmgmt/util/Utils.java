package com.hotelmgmt.util;

public class Utils {

	public static String getDayType(String date) {
		if(date.equals("sat") || date.equals("sun"))
			return "weekend";
		else
			return "weekday";
	}
}
