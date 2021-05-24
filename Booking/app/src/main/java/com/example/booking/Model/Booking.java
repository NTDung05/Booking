package com.example.booking.Model;

public class Booking {
private  String Ndat;
private  String Ntra;
private String type;
private  String gia;
private  String ava;

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    public Booking() {
    }

    public Booking(String ndat, String ntra, String type, String gia, String ava) {
        Ndat = ndat;
        Ntra = ntra;
        this.type = type;
        this.gia = gia;
        this.ava = ava;
    }

    public String getNdat() {
        return Ndat;
    }

    public void setNdat(String ndat) {
        Ndat = ndat;
    }

    public String getNtra() {
        return Ntra;
    }

    public void setNtra(String ntra) {
        Ntra = ntra;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
