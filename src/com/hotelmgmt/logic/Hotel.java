package com.hotelmgmt.logic;

import java.util.List;

import com.hotelmgmt.util.Constants.CustomerType;

public interface Hotel {
	
	public int getRating();
	public String getName();
	public int getPrice(CustomerType customerType, List<String> dates);
	public void setName(String string);
	public void setRating(int i);
	public void setCustomer(CustomerType customerType, Customer regularCustomer);
	public Customer getCustomer(CustomerType customerType);
}
