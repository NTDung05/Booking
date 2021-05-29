package com.example.booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.booking.Model.Customer;
import com.example.booking.Model.Users;

import java.util.concurrent.atomic.AtomicBoolean;

public class EditProfileActivity extends AppCompatActivity {
    ImageView imgProfile, imgAva, imgEdProfile;
    EditText edTaiKhoan, edHoTen, edPhone, edEmail, edPassword, edConfirm;
    Users users;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Edit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_edit_profile);
        users = new Users();
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        if (bundle != null) {
            customer = (Customer) bundle.getSerializable("customer");
        }
        setControl();
        setEvent(users, customer);

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

    public void setEvent(Users users, Customer customer) {
        if (customer != null) {
            edTaiKhoan.setText(customer.getUsername().getUserName().toString());
            edEmail.setText(customer.getEmail().toString());
            edHoTen.setText(customer.getLastName().toString() +" "+ customer.getFirstName().toString());
            edPhone.setText(String.valueOf(customer.getPhone()));

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
                customer.setPhone(Integer.parseInt(phone));
                customer.setUsername(users);
                String hoten = edHoTen.getText().toString();
                int i = hoten.lastIndexOf(" ");
                String first = hoten.substring(i + 1);
                String last = hoten.substring(0, i);
                customer.setFirstName(first);
                customer.setLastName(last);
                customer.setId(1);
                if (check.get()==true) {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("customer", customer);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                if (check.get()==false) {
                    Toast.makeText(getApplicationContext(), "Vui lòng xác nhận lại mật khẩu", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}
