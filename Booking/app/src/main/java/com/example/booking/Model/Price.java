package com.example.booking.Model;

public class Price {
     private Room_type type_id;
     private int weekend;
     private int price;

    public Price() {
    }

    public Price(Room_type type_id, int weekend, int price) {
        this.type_id = type_id;
        this.weekend = weekend;
        this.price = price;
    }

    public Room_type getType_id() {
        return type_id;
    }

    public void setType_id(Room_type type_id) {
        this.type_id = type_id;
    }

    public int getWeekend() {
        return weekend;
    }

    public void setWeekend(int weekend) {
        this.weekend = weekend;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
