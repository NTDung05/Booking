package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Room implements Serializable {
    @SerializedName("roomCode")
    private String code;
    @SerializedName("numberOfBed")
    private int type;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String avatar;
    @SerializedName("status")
    private  String status;

    public Room(String code, int type, String description, String avatar, String status) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.avatar = avatar;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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