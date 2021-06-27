package com.hotelmgmt.application;

import java.util.ArrayList;
import java.util.List;

import com.hotelmgmt.logic.Customer;
import com.hotelmgmt.logic.CustomerImpl;
import com.hotelmgmt.logic.Hotel;
import com.hotelmgmt.logic.HotelImpl;
import com.hotelmgmt.util.Constants;
import com.hotelmgmt.util.Constants.CustomerType;

public class HotelApplication {

	public static void main(String[] args) {

		List<String> dates = new ArrayList<String>();
		CustomerType customerType = CustomerType.Regular;

		/* ------------- Start setting hotels details ---------------- */

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

		/* ------------- End setting hotels details ---------------- */

		HotelApplication hotelApplication = new HotelApplication();
		System.out.println("Cheapest Hotel would be: " + hotelApplication.getChepestHotel(hotels, customerType, dates));
	}

	public String getChepestHotel(List<Hotel> hotels, CustomerType customerType, List<String> dates) {

		String cheapestHotel = null;
		int leastPrice = Integer.MAX_VALUE;
		int leastPriceHotelRating = 0;

		for (Hotel hotel : hotels) {
			if (leastPrice > hotel.getPrice(customerType, dates)) {
				cheapestHotel = hotel.getName();
				leastPrice = hotel.getPrice(customerType, dates);
				leastPriceHotelRating = hotel.getRating();
			} else if (leastPrice == hotel.getPrice(customerType, dates)) {
				if (leastPriceHotelRating < hotel.getRating()) {
					cheapestHotel = hotel.getName();
					leastPriceHotelRating = hotel.getRating();
				}
			}
		}

		return cheapestHotel;
	}
}
