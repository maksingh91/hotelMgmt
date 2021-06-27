package com.hotelmgmt.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hotelmgmt.util.Constants.CustomerType;
import com.hotelmgmt.util.Constants.DayType;
import com.hotelmgmt.util.Utils;

public class HotelImpl implements Hotel {

	private int rating;
	private String name;
	private Map<CustomerType, Customer> customerTypes = new HashMap<CustomerType, Customer>();

	@Override
	public int getRating() {
		return this.rating;
	}

	@Override
	public int getPrice(CustomerType customerType, List<String> dates) {
		int totalPrice = 0;
		for (String date : dates) {
			DayType day = Utils.getDayType(date);
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
	public void setCustomer(CustomerType customerType, Customer customer) {
		this.customerTypes.put(customerType, customer);

	}

	@Override
	public Customer getCustomer(CustomerType customerType) {
		return this.customerTypes.get(customerType);

	}
}
