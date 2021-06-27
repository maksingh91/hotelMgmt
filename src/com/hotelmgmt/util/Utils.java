package com.hotelmgmt.util;

import com.hotelmgmt.util.Constants.DayType;

public class Utils {

	public static DayType getDayType(String date) {
		if(date.equals("sat") || date.equals("sun"))
			return DayType.Weekend;
		else
			return DayType.Weekday;
	}
}
