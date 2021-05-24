package com.example.booking.Model;

public class Customer_Renting {
      private Booking_card bookingCard_id;
      private Room code;
      private Customer customer_id;

    public Customer_Renting(Booking_card bookingCard_id, Room code, Customer customer_id) {
        this.bookingCard_id = bookingCard_id;
        this.code = code;
        this.customer_id = customer_id;
    }

    public Booking_card getBookingCard_id() {
        return bookingCard_id;
    }

    public void setBookingCard_id(Booking_card bookingCard_id) {
        this.bookingCard_id = bookingCard_id;
    }

    public Room getCode() {
        return code;
    }

    public void setCode(Room code) {
        this.code = code;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }
}
