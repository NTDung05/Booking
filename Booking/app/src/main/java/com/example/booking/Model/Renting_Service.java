package com.example.booking.Model;

public class Renting_Service {
     private Booking_card bookingCard_id;
     private Room room_code;
     private Customer customer_id;
     private  Service service_id;
     private int quantity;

    public Renting_Service() {
    }

    public Renting_Service(Booking_card bookingCard_id, Room room_code,
                           Customer customer_id, Service service_id,
                           int quantity) {
        this.bookingCard_id = bookingCard_id;
        this.room_code = room_code;
        this.customer_id = customer_id;
        this.service_id = service_id;
        this.quantity = quantity;
    }

    public Booking_card getBookingCard_id() {
        return bookingCard_id;
    }

    public void setBookingCard_id(Booking_card bookingCard_id) {
        this.bookingCard_id = bookingCard_id;
    }

    public Room getRoom_code() {
        return room_code;
    }

    public void setRoom_code(Room room_code) {
        this.room_code = room_code;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Service getService_id() {
        return service_id;
    }

    public void setService_id(Service service_id) {
        this.service_id = service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
