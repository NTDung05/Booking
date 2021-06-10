package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Users implements Serializable {
    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;
    @SerializedName("roleName")
    private String roleName;

    public Users(String userName, String password, String roleName) {
        this.userName = userName;
        this.password = password;
        this.roleName = roleName;
    }

    public Users() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
