package com.hotelmgmt.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hotelmgmt.util.Utils;

public class HotelImpl implements Hotel {

	private int rating;
	private String name;
	private Map<String, Customer> customerTypes = new HashMap<String, Customer>();

	@Override
	public int getRating() {
		return this.rating;
	}

	@Override
	public int getPrice(String customerType, List<String> dates) {
		int totalPrice = 0;
		for (String date : dates) {
			String day = Utils.getDayType(date);
			totalPrice = totalPrice + this.getCustomer(customerType).getRate(day);
		}
		return totalPrice;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setRating(int rating) {
		this.rating = rating;

	}

	@Override
	public void setCustomer(String customerType, Customer regularCustomer) {
		this.customerTypes.put(customerType, regularCustomer);

	}

	@Override
	public Customer getCustomer(String customerType) {
		return this.customerTypes.get(customerType);

	}
}
