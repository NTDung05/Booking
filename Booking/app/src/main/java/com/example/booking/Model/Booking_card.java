package com.example.booking.Model;

public class Booking_card {
    private  int id;
    private Customer customer_id;
    private Discount discount_id;
    private String status;
    private int price;

    public Booking_card(int id, Customer customer_id,
                        Discount discount_id, String status,
                        int price) {
        this.id = id;
        this.customer_id = customer_id;
        this.discount_id = discount_id;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Discount getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(Discount discount_id) {
        this.discount_id = discount_id;
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
