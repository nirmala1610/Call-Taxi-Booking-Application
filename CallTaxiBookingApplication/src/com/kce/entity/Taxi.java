package com.kce.entity;

import java.util.List;

public class Taxi {

	private int taxiId;
	private char currentPoint;
	private int freeTime;
	private int totalEarnings;
	private List<Booking> bookings;
	public int getTaxiId() {
		return taxiId;
	}
	public void setTaxiId(int taxiId) {
		this.taxiId = taxiId;
	}
	public char getCurrentPoint() {
		return currentPoint;
	}
	public void setCurrentPoint(char currentPoint) {
		this.currentPoint = currentPoint;
	}
	public int getFreeTime() {
		return freeTime;
	}
	public void setFreeTime(int freeTime) {
		this.freeTime = freeTime;
	}
	public int getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(int totalEarnigs) {
		this.totalEarnings = totalEarnigs;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
}
