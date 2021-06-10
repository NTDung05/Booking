package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.booking.Api.ApiService;
import com.example.booking.Model.Customer;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {


        EditText etName,etPassword,etMobile,etEmail,etConfirmPassword,et_firstname,et_lastname;
        Button btSubmit;
        AwesomeValidation awesomeValidation;
        Users users;
        CustomerTest customer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            users = new Users();
            customer = new CustomerTest();
           et_firstname =(EditText) findViewById(R.id.et_firstname);
            et_lastname = (EditText)findViewById(R.id.et_lastname);
            etName = (EditText) findViewById(R.id.et_name);
            etMobile = (EditText) findViewById(R.id.et_mobile);
            etEmail = (EditText) findViewById(R.id.et_email);
            etPassword = (EditText) findViewById(R.id.et_password);
            etConfirmPassword =(EditText) findViewById(R.id.et_confirm_password);
            btSubmit= (Button) findViewById(R.id.bt_submit);

            awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
            //add valid name
            awesomeValidation.addValidation(this,R.id.et_name,
                    RegexTemplate.NOT_EMPTY,R.string.invalid_name);
//            //add valid Phone
//            awesomeValidation.addValidation(this,R.id.et_mobile,
//                    "[0-9]{1}[0-9]{9}$",R.string.ivalid_mobile);
//            //for email
//            awesomeValidation.addValidation(this,R.id.et_email,
//                    Patterns.EMAIL_ADDRESS, R.string.invalid_email);
//            //for password
//            awesomeValidation.addValidation(this,R.id.et_password,
//                    ".{6,}",R.string.invalid_password);
//            //for confirmpass
//            awesomeValidation.addValidation(this,R.id.et_confirm_password,
//                    R.id.et_password,R.string.invalid_confirm_password);
//            //btn


            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // check validation
                    if (awesomeValidation.validate()){
                        //on success
                        users.setUserName(etName.getText().toString());
                        users.setPassword(etPassword.getText().toString());
                        users.setRoleName("Customer");
                        CreateUser();
                        Toast.makeText(getApplicationContext()
                                ,users.getUserName(),Toast.LENGTH_SHORT).show();
                        customer.setUsername(users.getUserName());
                        customer.setEmail(etEmail.getText().toString());
                        customer.setFirstName(et_firstname.getText().toString());
                        customer.setLastName(et_lastname.getText().toString());
                        customer.setPhone(etMobile.getText().toString());
                        CreateCustomer();
                        Toast.makeText(getApplicationContext()
                                ,"Form valid successfull...",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext()
                                ,"Validation Faild.",Toast.LENGTH_SHORT).show();
                    }
                }
            });



        }
        private  void CreateUser(){
            ApiService.API_SERVICE.createUser(users).enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    Toast.makeText(getApplicationContext(), "Thành công User", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Try user", Toast.LENGTH_LONG).show();
                }
            });
        }
    private  void CreateCustomer(){
        ApiService.API_SERVICE.createCustomer(customer).enqueue(new Callback<CustomerTest>() {
            @Override
            public void onResponse(Call<CustomerTest> call, Response<CustomerTest> response) {
                Toast.makeText(getApplicationContext(), "Thành công custom", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<CustomerTest> call, Throwable t) {
                Toast.makeText(getApplicationContext(), " Try Cus", Toast.LENGTH_LONG).show();
            }
        });
    }
    }

