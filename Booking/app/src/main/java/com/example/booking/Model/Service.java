package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

public class Service {
    @SerializedName("bookingId")
    private  int bookingcart_id;
    @SerializedName("serviceId")
    private int id;
    @SerializedName("serviceName")
    private  String service_name;
    private int price;
    private int quantity;

    public Service(int id, String service_name, int price, int quantity) {
        this.id = id;

        this.service_name = service_name;
        this.price = price;
        this.quantity = quantity;
    }

    public Service(int id, String service_name, int price) {
        this.id = id;
        this.service_name = service_name;
        this.price = price;
    }

    public int getBookingcart_id() {
        return bookingcart_id;
    }

    public void setBookingcart_id(int bookingcart_id) {
        this.bookingcart_id = bookingcart_id;
    }

    public Service() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
