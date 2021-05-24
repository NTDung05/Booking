package com.example.booking.Model;

public class Booking_Detail {

    private Booking_card booking_card_id;
    private int type_id;
    private String receive_at;
    private String back_at;
    private int amount;

    public Booking_Detail(Booking_card booking_card_id,
                          int type_id, String receive_at,
                          String back_at, int amount) {
        this.booking_card_id = booking_card_id;
        this.type_id = type_id;
        this.receive_at = receive_at;
        this.back_at = back_at;
        this.amount = amount;
    }

    public Booking_card getBooking_card_id() {
        return booking_card_id;
    }

    public void setBooking_card_id(Booking_card booking_card_id) {
        this.booking_card_id = booking_card_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getReceive_at() {
        return receive_at;
    }

    public void setReceive_at(String receive_at) {
        this.receive_at = receive_at;
    }

    public String getBack_at() {
        return back_at;
    }

    public void setBack_at(String back_at) {
        this.back_at = back_at;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
