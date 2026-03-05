## Call Taxi Booking Application


## 📖 Overview
This is a Java console application that simulates a taxi booking system. Customers can book taxis available at certain points along a linear route. The system allocates taxis based on availability, nearest location, and earnings, and calculates fares according to distance traveled.

## 🚖 Problem Assumptions
Taxi Count: Configurable (default 4 taxis).

Route Points: A → B → C → D → E → F (each 15 km apart).

Travel Time Between Points: 60 minutes per 15 km.

Charges:

Minimum ₹100 for the first 5 km.

₹10 per km thereafter.

Initial Position: All taxis start at point A.

## 📜 Booking Rules
A free taxi at the pickup point is allocated first.

If no free taxi is available at pickup, the nearest free taxi is allocated.

If two taxis are free at the same point, the one with lower earnings is allocated.

Taxis only charge from the pickup point to the drop point.

If no taxi is available, the booking is rejected.

## 🗂️ Project Structure

      CallTaxiBookingApplication/
      │
      ├── src/
      │   ├── com.kce.entity/
      │   │   ├── Taxi.java        # Taxi entity
      │   │   ├── Booking.java     # Booking entity
      │   │   └── Customer.java    # Customer entity
      │   │
      │   ├── com.kce.service/
      │   │   └── BookingService.java  # Business logic for booking & display
      │   │
      │   ├── com.kce.main/
      │   │   └── Main.java        # Console entry point with menu
      │   │
      │   └── module-info.java
      
## ▶️ How to Run
Clone or download the project.

Open in your IDE (Eclipse/IntelliJ) or compile with javac.

Run the Main class.

Use the interactive menu:

1. Book a Taxi → Enter customer ID, pickup point, drop point, and pickup time.

2. Display Details → Shows earnings and booking history of taxis.

3. Exit → Quit the program.

## 🖥️ Sample Console Flow

<img width="1067" height="458" alt="image" src="https://github.com/user-attachments/assets/952362ac-d2cb-498c-b1e6-7ec47affa0bf" />


<img width="1067" height="309" alt="image" src="https://github.com/user-attachments/assets/44590c8e-4b7d-486b-b621-c8e90d459038" />

## 📌 Notes
The application uses only Java collections (ArrayList) for storing taxis and bookings.

The system is scalable to any number of taxis and route points.

Output can be customized to show either all taxis or only those with bookings.
