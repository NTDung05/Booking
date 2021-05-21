package com.example.booking.Model;

import java.io.Serializable;

public class Room implements Serializable {
    private String code;
    private String type;
    private String description;
    private String avatar;

    public Room(String code, String type, String description, String avatar) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.avatar = avatar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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