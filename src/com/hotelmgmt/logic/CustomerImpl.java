package com.hotelmgmt.logic;

import java.util.HashMap;
import java.util.Map;

import com.hotelmgmt.util.Constants.DayType;

public class CustomerImpl implements Customer {
	
	Map<DayType, Integer> rates = new HashMap<DayType, Integer>();

	@Override
	public void setRate(DayType day, int rate) {
		this.rates.put(day, rate);
		
	}

	@Override
	public int getRate(DayType day) {
		return this.rates.get(day);
	}

}
