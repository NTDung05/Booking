package com.example.booking.Model;

import java.io.Serializable;

public class Room_type  implements Serializable {

    private int id;
    private int number_of_bed;

    public Room_type(int id, int number_of_bed) {
        this.id = id;
        this.number_of_bed = number_of_bed;
    }

    public Room_type() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_of_bed() {
        return number_of_bed;
    }

    public void setNumber_of_bed(int number_of_bed) {
        this.number_of_bed = number_of_bed;
    }
}
