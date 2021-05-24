package com.example.booking.Model;

public class Renting_Detail {

    private Booking_card bookingCard_id;
    private Room code;
    private String rent_at;
    private String back_at;
    private int staff_id;

    public Renting_Detail() {
    }

    public Renting_Detail(Booking_card bookingCard_id, Room code,
                          String rent_at, String back_at, int staff_id) {
        this.bookingCard_id = bookingCard_id;
        this.code = code;
        this.rent_at = rent_at;
        this.back_at = back_at;
        this.staff_id = staff_id;
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

    public String getRent_at() {
        return rent_at;
    }

    public void setRent_at(String rent_at) {
        this.rent_at = rent_at;
    }

    public String getBack_at() {
        return back_at;
    }

    public void setBack_at(String back_at) {
        this.back_at = back_at;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
}
