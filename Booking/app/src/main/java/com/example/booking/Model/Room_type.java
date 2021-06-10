package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Room_type  implements Serializable {
    @SerializedName("id")
     private int id_Type;
     @SerializedName("numberOfBed")
    private int number_of_bed;
    private  String name;
    @SerializedName("desciption")
    private  String description;
    private int price;

    public int getId_Type() {
        return id_Type;
    }

    public void setId_Type(int id_Type) {
        this.id_Type = id_Type;
    }

    public int getNumber_of_bed() {
        return number_of_bed;
    }

    public void setNumber_of_bed(int number_of_bed) {
        this.number_of_bed = number_of_bed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
