package com.example.booking.Model;

import java.io.Serializable;

public class YBookingDetail implements Serializable {
    private int bookingcart_id;
    private  int idType;
    private String nameType;
    private int numberOfBed;
    private String recieveAt;
    private String backAt;
    private int amount;
    private int price;



    public int getBookingcart_id() {
        return bookingcart_id;
    }

    public void setBookingcart_id(int bookingcart_id) {
        this.bookingcart_id = bookingcart_id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public String getRecieveAt() {
        return recieveAt;
    }

    public void setRecieveAt(String recieveAt) {
        this.recieveAt = recieveAt;
    }

    public String getBackAt() {
        return backAt;
    }

    public void setBackAt(String backAt) {
        this.backAt = backAt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
