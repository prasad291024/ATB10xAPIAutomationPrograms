package com.prasad_v.ex_10_PayloadMagement.manual_01;
// Defines the package in which this class is located.

import com.prasad_v.ex_10_PayloadMagement.AI.BookingDates;
// Imports the BookingDates class, which represents the check-in and check-out dates.

public class Booking {
    // This class represents a **hotel booking** with attributes like name, price, deposit status, etc.

    // Declaring private member variables to store booking details.
    private String firstname;  // Stores the first name of the person making the booking.
    private String lastname;  // Stores the last name of the person making the booking.
    private Integer totalprice;  // Stores the total price of the booking.
    private Boolean depositpaid;  // Stores whether the deposit has been paid (true/false).
    private String additionalneeds;  // Stores any additional requirements like breakfast, parking, etc.
    private BookingDates bookingdates;  // Stores check-in and check-out dates as a separate object.

    // Getter method for firstname
    public String getFirstname() {
        return firstname;  // Returns the firstname of the person who booked the hotel.
    }

    // Setter method for firstname
    public void setFirstname(String firstname) {
        this.firstname = firstname;  // Sets the firstname of the booking.
    }

    // Getter method for lastname
    public String getLastname() {
        return lastname;  // Returns the lastname of the booking.
    }

    // Setter method for lastname
    public void setLastname(String lastname) {
        this.lastname = lastname;  // Sets the lastname of the booking.
    }

    // Getter method for totalprice
    public Integer getTotalprice() {
        return totalprice;  // Returns the total price of the booking.
    }

    // Setter method for totalprice
    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;  // Sets the total price for the booking.
    }

    // Getter method for depositpaid
    public Boolean getDepositpaid() {
        return depositpaid;  // Returns true if deposit is paid, otherwise false.
    }

    // Setter method for depositpaid
    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;  // Sets whether the deposit is paid or not.
    }

    // Getter method for additionalneeds
    public String getAdditionalneeds() {
        return additionalneeds;  // Returns additional needs like "Breakfast", "WiFi", etc.
    }

    // Setter method for additionalneeds
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;  // Sets additional needs for the booking.
    }

    // Getter method for bookingdates
    public BookingDates getBookingdates() {
        return bookingdates;  // Returns the booking dates (check-in and check-out).
    }

    // Setter method for bookingdates
    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;  // Sets the check-in and check-out dates.
    }
}
