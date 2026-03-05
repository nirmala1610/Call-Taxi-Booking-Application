package com.kce.service;

import java.util.ArrayList;
import java.util.List;

import com.kce.entity.Booking;
import com.kce.entity.Taxi;

public class BookingService {
	
	private List<Taxi> taxis;
	private int bookingCount = 1;
	
	public BookingService(int taxiCount) {
		taxis = new ArrayList<Taxi>();
		for(int i=1;i<=taxiCount;i++) {
			Taxi taxi = new Taxi();
			taxi.setTaxiId(i);
			taxi.setCurrentPoint('A');
			taxi.setFreeTime(0);
			taxi.setTotalEarnings(0);
			taxi.setBookings(new ArrayList<Booking>());
			taxis.add(taxi);
		}
	}
	
	public void bookTaxi(int customerId,char pickupPoint,char dropPoint,int pickupTime) {
		Taxi choosenTaxi = findTaxi(pickupPoint, pickupTime);
		if(choosenTaxi==null) {
			System.out.println("Booking rejected");
			return ;
		}
		
		int distance = Math.abs(dropPoint - pickupPoint) * 15;
		int amount = 100 + (distance-5)*10;
		int travelTime = distance/15;
		int dropTime = pickupTime + travelTime;
		
		Booking booking = new Booking();
		booking.setBookingId(bookingCount++);
		booking.setCustomerId(customerId);
		booking.setPickupPoint(pickupPoint);
		booking.setDropPoint(dropPoint);
		booking.setPickupTime(pickupTime);
		booking.setDropTime(dropTime);
		booking.setAmount(amount);
		
		choosenTaxi.getBookings().add(booking);
		choosenTaxi.setTotalEarnings(choosenTaxi.getTotalEarnings()+amount);
		choosenTaxi.setCurrentPoint(dropPoint);
		choosenTaxi.setFreeTime(dropTime);
		
		System.out.println("Taxi can be Alloted : Taxi - " + choosenTaxi.getTaxiId()+" is alloted");
	}
	
	public Taxi findTaxi(char pickupPoint,int pickupTime) {
		Taxi nearTaxi = null;
		int minDistance = Integer.MAX_VALUE;
		
		for(Taxi taxi : taxis) {
			if(taxi.getFreeTime() <= pickupTime) {
				int distance = Math.abs(taxi.getCurrentPoint()-pickupPoint);
				if(distance<minDistance || 
						(distance==minDistance && 
						taxi.getTotalEarnings()<(nearTaxi != null ? nearTaxi.getTotalEarnings() : Integer.MAX_VALUE))) {
					nearTaxi = taxi ;
					minDistance = distance ;
				}
			}
		}
		return nearTaxi;
	}

	public void displayDetails() {
		for(Taxi taxi : taxis) {
			if (!taxi.getBookings().isEmpty()) {
			System.out.println("Taxi- "+taxi.getTaxiId() + " Total Earnings:" + taxi.getTotalEarnings());
			
			for(Booking b : taxi.getBookings()) {
				System.out.println("BookingId:"+b.getBookingId());
				System.out.println("CustomerId:" + b.getCustomerId());
				System.out.println("PickUpPoint:"+b.getPickupPoint());
				System.out.println("Drop Point : " + b.getDropPoint());
				System.out.println("PickupTime :"+b.getPickupTime());
				System.out.println("Drop Time:" + b.getDropTime());
				System.out.println("Amount : " + b.getAmount());
			}
			System.out.println();
			}
		}
	}
	
}
