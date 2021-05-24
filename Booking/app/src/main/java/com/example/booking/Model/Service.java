package com.example.booking.Model;

public class Service {
    private int id;
    private  String service_name;
    private int price;

    public Service(int id, String service_name, int price) {
        this.id = id;
        this.service_name = service_name;
        this.price = price;
    }

    public Service() {
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
