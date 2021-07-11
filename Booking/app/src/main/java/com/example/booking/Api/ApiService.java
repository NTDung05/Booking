package com.example.booking.Api;

import com.example.booking.Model.Booking_Detail;
import com.example.booking.Model.Booking_card;
import com.example.booking.Model.Customer;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Month;
import com.example.booking.Model.Room;
import com.example.booking.Model.Room_type;
import com.example.booking.Model.Service;
import com.example.booking.Model.Service_detail;
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
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
//{{host}}api/customers/tien156
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
     ApiService API_SERVICE = new Retrofit.Builder().baseUrl("http://192.168.1.4:8082/")
             .addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);
      @GET("api/customers/{username}")
     Call<CustomerTest> convertCustomer(@Path("username") String username);

    @GET("api/users/{username}")
    Call<Users> convertUser(@Path("username") String username);



    @POST("api/users")
    Call<Users> createUser(@Body Users users);

    @POST("api/auth/signin")
    Call<Boolean> signIn(@Body Users users);

    @POST("api/customers")
    Call<CustomerTest> createCustomer(@Body CustomerTest customer);

    @PUT("api/customers/{username}")
    Call<CustomerTest> UpdateCustomer(@Path("username") int s,
                                      @Body CustomerTest customer);



    @POST("api/bookingDetail")
    Call<Booking_Detail> PostBookingRoom(@Body Booking_Detail booking_detail);

    @POST("api/serviceDetail")
    Call<Service_detail> PostService(@Body Service_detail service);

    @GET("api/bookingCards")
    Call<Month>  GetChart(@Query("year") int year);

    @GET("api/types/{time}")
    Call<List<Room_type>> GetListTypeRoom(@Path("time") int time);


    @GET("api/services")
    Call<List<Service>> GetListService();

    // list Bill theo user
    @GET("api/bookingCards/{username}")
    Call<List<Booking_card>> GetListYourBooking (@Path("username") String username);




    @GET("api/bookingDetail/{username}/{bookingID}")
    Call<List<YBookingDetail>> GetBookingDetail (@Path("username") String username,
                                           @Path("bookingID") int id);


    @GET("api/bookingDetail/{username}/0")
    Call<List<YBookingDetail>> GetBookingDetailCart (@Path("username") String username);

    //Gio hg theo user
    @GET("api/serviceDetail/{username}/0")
    Call<List<Service>> GetServiceDetailCart (@Path("username") String username);


    @GET("api/serviceDetail/{username}/{bookingID}")
    Call<List<Service>> GetServiceDetail (@Path("username") String username,
                                          @Path("bookingID") int id);

    @PUT("api/bookingCards/{bookingId}/{isCancel}")
    Call<Booking_card> ChangeStatus (@Path("bookingId") int id, @Path("isCancel") Boolean cancel);

    @DELETE("api/bookingDetail")
    Call<YBookingDetail> DeleteRoom (@Query("bookingCard")  int id,@Query("type")  int idRoom);

    @DELETE("api/serviceDetail")
    Call<Service> DeleteService (@Query("bookingCard")  int id,@Query("service")  int idService);


}
