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
import com.hotelmgmt.util.Constants;
import com.hotelmgmt.util.Constants.CustomerType;


public class TestLogic {

	@Test
	public void testGetChepestHotel(){
		List<String> dates = new ArrayList<String>();
		dates.add("fri");
		dates.add("sat");
		
		
		CustomerType customerType=CustomerType.Regular;
		
		/* ------------- Start setting hotels details  ---------------- */
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		
		Hotel lakewood = new HotelImpl();
		lakewood.setName("Lakewood");
		lakewood.setRating(3);
		Customer regularCustomer = new CustomerImpl();
		regularCustomer.setRate(Constants.DayType.Weekend, 90);
		regularCustomer.setRate(Constants.DayType.Weekday, 110);
		lakewood.setCustomer(CustomerType.Regular, regularCustomer);
		
		Customer rewardsCustomer = new CustomerImpl();
		regularCustomer.setRate(Constants.DayType.Weekend, 80);
		regularCustomer.setRate(Constants.DayType.Weekday, 80);
		lakewood.setCustomer(CustomerType.Rewards, rewardsCustomer);
		hotels.add(lakewood);
		
		Hotel bridgewood = new HotelImpl();
		bridgewood.setName("Bridgewood");
		bridgewood.setRating(4);
		regularCustomer = new CustomerImpl();
		regularCustomer.setRate(Constants.DayType.Weekend, 60);
		regularCustomer.setRate(Constants.DayType.Weekday, 160);
		bridgewood.setCustomer(CustomerType.Regular, regularCustomer);
		
		rewardsCustomer = new CustomerImpl();
		regularCustomer.setRate(Constants.DayType.Weekend, 50);
		regularCustomer.setRate(Constants.DayType.Weekday, 110);
		bridgewood.setCustomer(CustomerType.Rewards, rewardsCustomer);
		hotels.add(bridgewood);
		
		Hotel ridgewood = new HotelImpl();
		ridgewood.setName("Ridgewood");
		ridgewood.setRating(5);
		regularCustomer = new CustomerImpl();
		regularCustomer.setRate(Constants.DayType.Weekend, 150);
		regularCustomer.setRate(Constants.DayType.Weekday, 220);
		ridgewood.setCustomer(CustomerType.Regular, regularCustomer);
		
		rewardsCustomer = new CustomerImpl();
		regularCustomer.setRate(Constants.DayType.Weekend, 40);
		regularCustomer.setRate(Constants.DayType.Weekday, 100);
		ridgewood.setCustomer(CustomerType.Rewards, rewardsCustomer);
		hotels.add(ridgewood);
		
		/* ------------- End setting hotels details  ---------------- */
		
		HotelApplication hotelApplication = new HotelApplication();
		
		assertEquals("Ridgewood",hotelApplication.getChepestHotel(hotels, customerType, dates));
	}
}
