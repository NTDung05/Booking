package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

public class Service_detail {
    @SerializedName("username")
    private String username;
    @SerializedName("nameService")
    private String nameService;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("price")
    private int price;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
