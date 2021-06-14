package com.example.booking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.booking.Adapter.ViewPagerAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Service;
import com.example.booking.Model.YBookingDetail;
import com.example.booking.fragment.RoomFragment;
import com.example.booking.fragment.ServiceFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YourbookingdetailActivity extends AppCompatActivity {
 private TabLayout mTabLayout;
 private ViewPager viewPager;
 private int id;
 private String username ;
 private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourbookingdetail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("YourBooking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //    sendDataService();
     //   sendData();
        ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        setControl();
        viewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        if (bundle != null) {

          int  id1 = bundle.getInt("ID");
          String  username1= bundle.getString("username");
          String status1 = bundle.getString("status");
          setId(id1);
          setUsername(username1);
          setStatus(status1);
        }

        setEvent();
    }
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
        mTabLayout = (TabLayout)findViewById(R.id.tbLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
    }

    public void setEvent() {

    }


}