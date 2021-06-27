package com.hotelmgmt.application;

import java.util.ArrayList;
import java.util.List;

import com.hotelmgmt.logic.Customer;
import com.hotelmgmt.logic.CustomerImpl;
import com.hotelmgmt.logic.Hotel;
import com.hotelmgmt.logic.HotelImpl;

public class HotelApplication {

	public static void main(String[] args) {

		List<String> dates = new ArrayList<String>();
		String customerType = "";
		String regularCustomerType = "Regular";
		String rewardsCustomerType = "Rewards";

		/* ------------- Start setting hotels details ---------------- */

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

		/* ------------- End setting hotels details ---------------- */

		HotelApplication hotelApplication = new HotelApplication();
		System.out.println("Cheapest Hotel would be: " + hotelApplication.getChepestHotel(hotels, customerType, dates));
	}

	public String getChepestHotel(List<Hotel> hotels, String customerType, List<String> dates) {

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
