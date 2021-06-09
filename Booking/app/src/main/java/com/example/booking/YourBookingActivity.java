package com.example.booking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.booking.Adapter.RoomAdapter;
import com.example.booking.Adapter.YourBookingAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.Model.Booking;
import com.example.booking.Model.Booking_Detail;
import com.example.booking.Model.Booking_card;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YourBookingActivity extends AppCompatActivity {
ListView lvYourBooking;
YourBookingAdapter customAdapter;
private List<Booking_card> listYourBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("YourBooking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_your_booking);
        listYourBooking = new ArrayList<>();

        setControl();
        callApiListBookingCard();
        setEvent();
    }@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setControl(){
        lvYourBooking = (ListView)findViewById(R.id.lvYourBooking);

    }
    public void setEvent(){
             lvYourBooking.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     Booking_card cardId = listYourBooking.get(position);
                     Toast.makeText(getApplicationContext(), String.valueOf(cardId.getId()), Toast.LENGTH_SHORT).show();

                 }
             });
    }
    public void  setAdapter(){

            customAdapter = new YourBookingAdapter(this, R.layout.custom_listview_yourbooking, listYourBooking);
            lvYourBooking.setAdapter(customAdapter);


    }
    private void callApiListBookingCard(){
        ApiService.API_SERVICE.GetListYourBooking("tien156").enqueue(new Callback<List<Booking_card>>() {
            @Override
            public void onResponse(Call<List<Booking_card>> call, Response<List<Booking_card>> response) {
                Toast.makeText(getApplicationContext(), "Hiiiiii", Toast.LENGTH_SHORT).show();
                listYourBooking = response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<Booking_card>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "try this", Toast.LENGTH_SHORT).show();
            }
        });
    }
}