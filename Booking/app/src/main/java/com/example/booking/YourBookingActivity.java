package com.example.booking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.booking.Adapter.RoomAdapter;
import com.example.booking.Adapter.YourBookingAdapter;
import com.example.booking.Model.Booking;

import java.util.ArrayList;
import java.util.List;

public class YourBookingActivity extends AppCompatActivity {
ListView lvYourBooking;
YourBookingAdapter customAdapter;
private List<Booking> listYourBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("YourBooking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_your_booking);
        listYourBooking = new ArrayList<>();
        Booking b = new Booking("12/01","15/01", "Phòng đôi",
                "2000","https://drive.google.com/file/d/11LF3L6zkaxYCk_kgyTUZMz_9R1iYs-8C/view?usp=sharing");

        Booking b1 = new Booking("20/02","28/02", "Phòng đơn",
                "5000","https://drive.google.com/file/d/13FcXbGvFC-dLr9FmE5KVgu3aPFyvZAgU/view?usp=sharing");
        Booking b2 = new Booking("05/05","10/05", "Phòng Master",
                "10.000","https://drive.google.com/file/d/1OZjkEwtexgL6wa4-GGPmud6FnmlJXBnf/view?usp=sharing");
        listYourBooking.add(b);
        listYourBooking.add(b1);
        listYourBooking.add(b2);
        setControl();
        setAdapter();
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

    }
    public void  setAdapter(){
        if (customAdapter == null) {
            customAdapter = new YourBookingAdapter(this, R.layout.custom_listview_yourbooking, listYourBooking);
            lvYourBooking.setAdapter(customAdapter);

        } else {
            customAdapter.notifyDataSetChanged();
            lvYourBooking.setSelection(customAdapter.getCount() - 1);
        }
    }
}