package com.example.booking.Model;

import com.google.gson.annotations.SerializedName;

public class Booking_Detail {

   private String username;
   @SerializedName("typeId")
   private int typeId;
   private String recieveAt;
   private String backAt;
   private  int amount;


   public Booking_Detail(String username, int id_type, String recieveAt, String backAt, int amount) {
      this.username = username;
      this.typeId = id_type;
      this.recieveAt = recieveAt;
      this.backAt = backAt;
      this.amount = amount;


   }

   public Booking_Detail() {
   }



   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public int getId_type() {
      return typeId;
   }

   public void setId_type(int id_type) {
      this.typeId = id_type;
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
}
