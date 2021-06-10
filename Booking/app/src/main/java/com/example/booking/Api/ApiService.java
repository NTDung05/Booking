package com.example.booking.Api;

import com.example.booking.Model.Booking_Detail;
import com.example.booking.Model.Booking_card;
import com.example.booking.Model.Customer;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Room;
import com.example.booking.Model.Room_type;
import com.example.booking.Model.Service;
import com.example.booking.Model.Users;
import com.example.booking.Model.YBookingDetail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Converter.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
//{{host}}api/customers/tien156
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
     ApiService API_SERVICE = new Retrofit.Builder().baseUrl("http://192.168.1.9:8082/")
             .addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);
      @GET("api/customers/{username}")
     Call<CustomerTest> convertCustomer(@Path("username") String username);

    @GET("api/users/{username}")
    Call<Users> convertUser(@Path("username") String username);

    @POST("api/users")
    Call<Users> createUser(@Body Users users);

    @POST("api/customers")
    Call<CustomerTest> createCustomer(@Body CustomerTest customer);

    @PUT("api/customers/{username}")
    Call<CustomerTest> UpdateCustomer(@Path("username") int s,
                                      @Body CustomerTest customer);

    @GET("api/types/{time}")
    Call<List<Room_type>> GetListTypeRoom(@Path("time") int time);

    @POST("api/bookingDetail")
    Call<Booking_Detail> PostBookingRoom(@Body Booking_Detail booking_detail);

    @GET("api/bookingDetail/{username}/{bookingID}")
    Call<List<YBookingDetail>> GetBookingDetail (@Path("username") String username,
                                           @Path("bookingID") int id);
    @GET("api/serviceDetail/{username}/{bookingID}")
    Call<List<Service>> GetServiceDetail (@Path("username") String username,
                                           @Path("bookingID") int id);

//    @GET("api/bookingDetail/{username}/0")
//    Call<YBookingDetail> GetBookingDetailCart (@Path("username") String username);
//
//    @GET("api/bookingDetail/{username}/0")
//    Call<Service> GetServiceDetailCart (@Path("username") String username);

    @GET("api/bookingCards/{username}")
    Call<List<Booking_card>> GetListYourBooking (@Path("username") String username);


}
