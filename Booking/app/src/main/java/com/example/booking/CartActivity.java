package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.booking.Adapter.CartAdapter;
import com.example.booking.Adapter.CartViewPagerAdapter;
import com.example.booking.Adapter.ServiceAdapter;
import com.example.booking.Adapter.ViewPagerAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.Model.Booking_card;
import com.example.booking.Model.Service;
import com.example.booking.Model.YBookingDetail;
import com.example.booking.fragment.CartServiceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {
    private TabLayout mTabLayout1;
    private ViewPager viewPager1;
    private int id;
    private String username ;
    BottomNavigationView navigationView;


    int bookingID = 0;
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
        setContentView(R.layout.activity_cart2);
         // bookingID = serviceFragment.bookingID;
        //    sendDataService();
        //   sendData();
        CartViewPagerAdapter viewPagerAdapter =new CartViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        setControl();
        viewPager1.setAdapter(viewPagerAdapter);
        mTabLayout1.setupWithViewPager(viewPager1);
        Intent myintent = getIntent();
        username = myintent.getStringExtra("name");
        setId(0);
        Toast.makeText(this,username,Toast.LENGTH_LONG).show();
        setEvent();
    }

    public void setControl(){
        mTabLayout1 = (TabLayout)findViewById(R.id.tbLayout1);
        viewPager1 = (ViewPager)findViewById(R.id.viewPager1);
        navigationView = (BottomNavigationView) findViewById(R.id.bottom);

    }

    public void setEvent() {


        navigationView.setSelectedItemId(R.id.nav_cart);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String name = username;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                        break;
                    case R.id.nav_booking:
                        Intent intent1 = new Intent(getApplicationContext(), BookingActivity.class);
                        intent1.putExtra("name", name);
                        startActivity(intent1);
                        break;
                    case R.id.nav_service:
                        Intent intent2 = new Intent(getApplicationContext(), ServiceActivivty.class);
                        intent2.putExtra("name", name);
                        startActivity(intent2);
                        break;
                    case R.id.nav_cart:
                        Intent intent3 = new Intent(getApplicationContext(), CartActivity.class);
                        intent3.putExtra("name", name);
                        startActivity(intent3);
                        break;
                    case R.id.nav_account:
                        Intent intent4 = new Intent(getApplicationContext(), ProfileActivity.class);
                        intent4.putExtra("name", name);
                        startActivity(intent4);
                        break;
                }

                return true;
            }
        });
    }

}