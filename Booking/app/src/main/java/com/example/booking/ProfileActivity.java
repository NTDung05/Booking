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

import com.example.booking.Model.Customer;

public class ProfileActivity extends AppCompatActivity {
    ImageView imgProfile;
    TextView tvTaiKhoan, tvPhone, tvHoTen;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_profile);
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        if (bundle != null) {
            customer = (Customer) bundle.getSerializable("customer");
        }
        setControl();
        setEvent(customer);

    }

    public void setControl() {
        imgProfile = (ImageView) findViewById(R.id.imgEdProfile);
        tvTaiKhoan = (TextView) findViewById(R.id.tvTaiKhoan);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvHoTen =(TextView)findViewById(R.id.tvHoTen);
    }

    public void setEvent(Customer customer) {
        if (customer != null) {
            tvPhone.setText(String.valueOf(customer.getPhone()));
            tvTaiKhoan.setText(customer.getUsername().getUserName().toString());
            tvHoTen.setText(customer.getLastName().toString()+" "+customer.getFirstName().toString());
        }
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("customer", customer);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
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
}