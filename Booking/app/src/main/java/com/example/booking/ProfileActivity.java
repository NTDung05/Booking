package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.Api.ApiService;
import com.example.booking.Model.Customer;
import com.example.booking.Model.CustomerTest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    ImageView imgProfile;
    TextView tvTaiKhoan, tvPhone, tvHoTen, tvEmail;
    Customer customer;
   private    CustomerTest customerTest;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        if (bundle != null) {
            customerTest = (CustomerTest) bundle.getSerializable("customer");
        }

        setControl();

        setEvent();

    }

    public void setControl() {
        navigationView = (BottomNavigationView) findViewById(R.id.bottom);
        imgProfile = (ImageView) findViewById(R.id.imgEdProfile);
        tvTaiKhoan = (TextView) findViewById(R.id.tvTaiKhoan);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvHoTen =(TextView)findViewById(R.id.tvHoTen);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
    }

    public void setEvent() {
        navigationView.setSelectedItemId(R.id.nav_account);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_booking:
                        Intent intent1 = new Intent(getApplicationContext(), BookingActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_service:
                        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_cart:
                        Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_account:
                        Intent intent4 = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent4);
                        break;
                }


                return true;
            }
        });
        if (customerTest != null) {
            tvTaiKhoan.setText(customerTest.getUsername().toString());
            tvEmail.setText(customerTest.getEmail().toString());
            tvHoTen.setText(customerTest.getLastName().toString() +" "+ customerTest.getFirstName().toString());
            tvPhone.setText(String.valueOf(customerTest.getPhone()));


        }


        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("customer",  customerTest);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


}