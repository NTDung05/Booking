package com.example.booking.Model;

import java.io.Serializable;

public class CustomerTest implements  Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String cmnd;
    public CustomerTest() {
    }

//    @Override
//    public String toString() {
//        return "CustomerTest{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phone='" + phone + '\'' +
//                ", email='" + email + '\'' +
//                ", username='" + username + '\'' +
//                '}';
//    }

    public CustomerTest(String firstName, String lastName, String phone, String email, String username, String cmnd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.cmnd = cmnd;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }


    public CustomerTest(String firstName, String lastName, String phone, String email, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
