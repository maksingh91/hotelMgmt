package com.hotelmgmt.logic;

import java.util.HashMap;
import java.util.Map;

public class CustomerImpl implements Customer {
	
	Map<String, Integer> rates = new HashMap<String, Integer>();

	@Override
	public void setRate(String day, int rate) {
		this.rates.put(day, rate);
		
	}

	@Override
	public int getRate(String day) {
		return this.rates.get(day);
	}

}
