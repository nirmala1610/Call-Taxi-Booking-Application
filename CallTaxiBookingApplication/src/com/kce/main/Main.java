package com.kce.main;

import java.util.Scanner;

import com.kce.service.BookingService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BookingService bookingService = new BookingService(6);
		
		System.out.println("Welcome to Call Taxi Booking System");
		 System.out.println();
		 boolean loop = true;
		 while(loop) {
			 System.out.println("1.Book a Taxi \n 2.DisplayDetails of Taxi's \n 3.Exit");
			 int choice = sc.nextInt();
			 switch (choice) {
			case 1: 
				System.out.println("Enter details to Book a Taxi : \n");
				System.out.println("Enter customerId : ");
				int cusomerId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter pickup point(A-F) in Character");
				char pickupPoint= sc.next().charAt(0);
				System.out.println("Enter Drop point(A-F) in Character");
				char dropPoint= sc.next().charAt(0);
				System.out.println("Enter PickUp time : ");
				int pickupTime = sc.nextInt();
				
				bookingService.bookTaxi(cusomerId, pickupPoint, dropPoint, pickupTime);
				break;
				
			case 2 :
				bookingService.displayDetails();
				break;
				
			case 3:
				loop = false;
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		 }

		 sc.close();
	}

}
