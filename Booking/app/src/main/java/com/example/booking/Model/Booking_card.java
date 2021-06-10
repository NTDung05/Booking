package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

public class Booking_card {
    @SerializedName("bookingId")
    private  int id;
   @SerializedName("status")
    private String status;
   @SerializedName("price")
    private int price;
 @SerializedName("username")
   private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
