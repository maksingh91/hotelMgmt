package com.hotelmgmt.testcase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hotelmgmt.application.HotelApplication;
import com.hotelmgmt.logic.Customer;
import com.hotelmgmt.logic.CustomerImpl;
import com.hotelmgmt.logic.Hotel;
import com.hotelmgmt.logic.HotelImpl;

public class TestLogic {

	@Test
	public void testGetChepestHotel(){
		List<String> dates = new ArrayList<String>();
		String customerType="";
		String regularCustomerType = "Regular";  
		String rewardsCustomerType = "Rewards";  
		
		/* ------------- Start setting hotels details  ---------------- */
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		
		Hotel lakewood = new HotelImpl();
		lakewood.setName("Lakewood");
		lakewood.setRating(3);
		Customer regularCustomer = new CustomerImpl();
		regularCustomer.setRate("weekend", 90);
		regularCustomer.setRate("weekday", 110);
		lakewood.setCustomer(regularCustomerType, regularCustomer);
		
		Customer rewardsCustomer = new CustomerImpl();
		regularCustomer.setRate("weekend", 80);
		regularCustomer.setRate("weekday", 80);
		lakewood.setCustomer(rewardsCustomerType, rewardsCustomer);
		
		Hotel bridgewood = new HotelImpl();
		bridgewood.setName("Bridgewood");
		bridgewood.setRating(4);
		regularCustomer = new CustomerImpl();
		regularCustomer.setRate("weekend", 60);
		regularCustomer.setRate("weekday", 160);
		bridgewood.setCustomer(regularCustomerType, regularCustomer);
		
		rewardsCustomer = new CustomerImpl();
		regularCustomer.setRate("weekend", 50);
		regularCustomer.setRate("weekday", 110);
		bridgewood.setCustomer(rewardsCustomerType, rewardsCustomer);
		
		Hotel ridgewood = new HotelImpl();
		ridgewood.setName("Ridgewood");
		ridgewood.setRating(5);
		regularCustomer = new CustomerImpl();
		regularCustomer.setRate("weekend", 150);
		regularCustomer.setRate("weekday", 220);
		ridgewood.setCustomer(regularCustomerType, regularCustomer);
		
		rewardsCustomer = new CustomerImpl();
		regularCustomer.setRate("weekend", 40);
		regularCustomer.setRate("weekday", 100);
		ridgewood.setCustomer(rewardsCustomerType, rewardsCustomer);
		
		/* ------------- End setting hotels details  ---------------- */
		
		HotelApplication hotelApplication = new HotelApplication();
		
		assertEquals("Bridgewater",hotelApplication.getChepestHotel(hotels, customerType, dates));
	}
}
