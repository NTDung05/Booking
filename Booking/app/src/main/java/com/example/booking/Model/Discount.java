package com.example.booking.Model;

public class Discount {
private int id;
private String discount_name;
private int discount_value;
private String use_at;
private String end_at;

    public Discount(int id, String discount_name,
                    int discount_value, String use_at,
                    String end_at) {
        this.id = id;
        this.discount_name = discount_name;
        this.discount_value = discount_value;
        this.use_at = use_at;
        this.end_at = end_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public int getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(int discount_value) {
        this.discount_value = discount_value;
    }

    public String getUse_at() {
        return use_at;
    }

    public void setUse_at(String use_at) {
        this.use_at = use_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }
}
