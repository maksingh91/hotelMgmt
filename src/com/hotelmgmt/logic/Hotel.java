package com.hotelmgmt.logic;

import java.util.List;

public interface Hotel {
	
	public int getRating();
	public String getName();
	public int getPrice(String customerType, List<String> dates);
	public void setName(String string);
	public void setRating(int i);
	public void setCustomer(String customerType, Customer regularCustomer);
	public Customer getCustomer(String customerType);
}
