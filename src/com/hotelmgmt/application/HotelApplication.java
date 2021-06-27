package com.hotelmgmt.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hotelmgmt.logic.Customer;
import com.hotelmgmt.logic.CustomerImpl;
import com.hotelmgmt.logic.Hotel;
import com.hotelmgmt.logic.HotelImpl;
import com.hotelmgmt.util.Constants;
import com.hotelmgmt.util.Constants.CustomerType;

public class HotelApplication {

	public static void main(String[] args) throws IOException {

		List<String> dates = new ArrayList<String>();

		Arrays.asList(args).stream().skip(1).forEach(s -> {
			dates.add(s.substring(s.indexOf('(')+1, s.indexOf(')')));
		});

		CustomerType customerType = CustomerType.valueOf(args[0].substring(0, args[0].length() - 1));

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
		rewardsCustomer.setRate(Constants.DayType.Weekend, 80);
		rewardsCustomer.setRate(Constants.DayType.Weekday, 80);
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
		rewardsCustomer.setRate(Constants.DayType.Weekend, 50);
		rewardsCustomer.setRate(Constants.DayType.Weekday, 110);
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
		rewardsCustomer.setRate(Constants.DayType.Weekend, 40);
		rewardsCustomer.setRate(Constants.DayType.Weekday, 100);
		ridgewood.setCustomer(CustomerType.Rewards, rewardsCustomer);
		hotels.add(ridgewood);

		/* ------------- End setting hotels details ---------------- */

		HotelApplication hotelApplication = new HotelApplication();
		System.out.println("Cheapest Hotel would be: " + hotelApplication.getChepestHotel(hotels, customerType, dates));
	}

	public String getChepestHotel(List<Hotel> hotels, CustomerType customerType, List<String> dates) {

		String cheapestHotel = null;
		int leastPrice = Integer.MAX_VALUE;
		int leastPriceHotelRating = 0;
		int hotelPrice = 0;

		for (Hotel hotel : hotels) {
			hotelPrice = hotel.getPrice(customerType, dates);
			if (leastPrice > hotelPrice) {
				cheapestHotel = hotel.getName();
				leastPrice = hotelPrice;
				leastPriceHotelRating = hotel.getRating();
			} else if (leastPrice == hotelPrice) {
				if (leastPriceHotelRating < hotel.getRating()) {
					cheapestHotel = hotel.getName();
					leastPriceHotelRating = hotel.getRating();
				}
			}
		}

		return cheapestHotel;
	}
}
