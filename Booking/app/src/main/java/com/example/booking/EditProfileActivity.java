package com.example.booking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.booking.Api.ApiService;
import com.example.booking.Model.Customer;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Users;

import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
    ImageView imgProfile, imgAva, imgEdProfile;
    EditText edTaiKhoan, edHoTen, edPhone, edEmail, edPassword, edConfirm;
    Users users = new Users();

    CustomerTest customer  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Edit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_edit_profile);

        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        if (bundle != null) {
            customer = (CustomerTest) bundle.getSerializable("customer");
        }
        setControl();
        callApi();

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
    public void setControl() {
        edTaiKhoan = (EditText) findViewById(R.id.edTaiKhoan);
        edHoTen = (EditText) findViewById(R.id.edHoTen);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edEmail = (EditText) findViewById(R.id.edEmail);
        imgAva = (ImageView) findViewById(R.id.imgAva);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        imgEdProfile = (ImageView) findViewById(R.id.imgEdProfile);
        edConfirm = (EditText) findViewById(R.id.edConfirm);
        edPassword = (EditText) findViewById(R.id.edPassword);


    }
 private void callApi(){
     ApiService.API_SERVICE.convertUser("tien156").enqueue(new Callback<Users>() {
         @Override
         public void onResponse(Call<Users> call, Response<Users> response) {
             Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();
             users = response.body();
             edPassword.setText(users.getPassword());
             edConfirm.setText(users.getPassword());
         }

         @Override
         public void onFailure(Call<Users> call, Throwable t) {
             Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
         }
     });
 }
    private void callApiUpdate(){
        ApiService.API_SERVICE.UpdateCustomer(2,customer).enqueue(new Callback<CustomerTest>() {
                    @Override
                    public void onResponse(Call<CustomerTest> call, Response<CustomerTest> response) {
                        Toast.makeText(getApplicationContext(), "Update thành công 123", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<CustomerTest> call, Throwable t) {
                     //   Toast.makeText(getApplicationContext(), "Thử lại", Toast.LENGTH_LONG).show();
                    }
                });
    }
    public void setEvent() {
        if (customer != null) {
            edTaiKhoan.setText(customer.getUsername().toString());
            edEmail.setText(customer.getEmail().toString());
            edHoTen.setText(customer.getLastName().toString() +" "+ customer.getFirstName().toString());
            edPhone.setText(String.valueOf(customer.getPhone()));
           // edPassword.setText(users.getPassword());

        }

        imgEdProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AtomicBoolean check = new AtomicBoolean(false);
                users.setUserName(edTaiKhoan.getText().toString());
                if (edPassword.getText().toString().equals(edConfirm.getText().toString())) {
                    users.setPassword(edPassword.getText().toString());
                    check.set(true);
                }
                customer.setEmail(edEmail.getText().toString());
                String phone="";
                phone = edPhone.getText().toString().trim();
                customer.setPhone(phone.trim());
              //  customer.setUsername(users.getUserName());
                String hoten = edHoTen.getText().toString();
                int i = hoten.lastIndexOf(" ");
                String first = hoten.substring(i + 1);
                String last = hoten.substring(0, i);
                customer.setFirstName(first);
                customer.setLastName(last);

                if (check.get()==true) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_LONG).show();
                    callApiUpdate();

                }
                if (check.get()==false) {
                    Toast.makeText(getApplicationContext(), "Vui lòng xác nhận lại mật khẩu", Toast.LENGTH_LONG).show();

                }
            }
        });


    }


}
