package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.booking.Api.ApiService;


import com.example.booking.Model.Customer;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Room;
import com.example.booking.Model.Room_type;
import com.example.booking.*;
import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton btBooking, btYBooking, btYProfile, btLocation;
    CustomerTest customerTest;
    List<Room_type> room;
    String username = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BOOKING HOTEL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          customerTest = new CustomerTest();
          Intent intent = getIntent();
          username = intent.getStringExtra("name");
        setContentView(R.layout.action_user);
        setControl();
        callApi();

        setEvent();
    }

    private void setControl() {
        btBooking = (ImageButton) findViewById(R.id.btBooking);
        btYBooking = (ImageButton) findViewById(R.id.btYBooking);
        btYProfile = (ImageButton) findViewById(R.id.btYProfile);
        btLocation = (ImageButton) findViewById(R.id.btLocation);
    }

    private void setEvent() {
        btBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BookingActivity.class);
                intent.putExtra("name", username);
                startActivity(intent);
            }
        });
        btYBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), YourBookingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",username);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btYProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("customer", customerTest);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceActivivty.class);
                intent.putExtra("name", username);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_out, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Cart){
            dialogSignOut();
        }
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void dialogSignOut(){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn thoát hay không ??? ");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogXoa.show();
    }
    private  void callApi(){

        ApiService.API_SERVICE.convertCustomer(username).enqueue(new Callback<CustomerTest>() {

            @Override
            public void onResponse(Call<CustomerTest> call, Response<CustomerTest> response ) {
                Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();

                customerTest  = response.body();




            }
            @Override
            public void onFailure(Call<CustomerTest> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
            }
        });

    }

}