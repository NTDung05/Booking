package com.example.booking;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    ImageView imgProfile;
    TextView tvTaiKhoan, tvPhone, tvHoTen, tvEmail;
    Customer customer;
   private    CustomerTest customerTest;

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
        imgProfile = (ImageView) findViewById(R.id.imgEdProfile);
        tvTaiKhoan = (TextView) findViewById(R.id.tvTaiKhoan);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvHoTen =(TextView)findViewById(R.id.tvHoTen);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
    }

    public void setEvent() {

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