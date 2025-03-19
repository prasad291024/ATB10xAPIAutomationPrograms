package com.prasad_v.ex_10_PayloadMagement.manual_01;
// Defines the package in which this class is located.

public class BookingDates {
    // This class represents the **check-in and check-out dates** for a booking.

    private String checkin;  // Stores the check-in date (format: YYYY-MM-DD)
    private String checkout; // Stores the check-out date (format: YYYY-MM-DD)

    // Getter method for checkout date
    public String getCheckout() {
        return checkout;  // Returns the checkout date.
    }

    // Setter method for checkout date
    public void setCheckout(String checkout) {
        this.checkout = checkout;  // Sets the checkout date.
    }

    // Getter method for check-in date
    public String getCheckin() {
        return checkin;  // Returns the check-in date.
    }

    // Setter method for check-in date
    public void setCheckin(String checkin) {
        this.checkin = checkin;  // Sets the check-in date.
    }
}
