package com.example.booking.Model;

import java.io.Serializable;

public class Room implements Serializable {
    private String code;
    private Room_type type;
    private String description;
    private String avatar;
    private  int status;

    public Room(String code, Room_type type, String description, String avatar, int status) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.avatar = avatar;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Room_type getType() {
        return type;
    }

    public void setType(Room_type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}