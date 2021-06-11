package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.booking.Api.ApiService;
import com.example.booking.Model.CustomerTest;
import com.example.booking.Model.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editUser,editPassword, register;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        setControl();
        setEvent();

    }
    public void setControl(){
        editUser = (EditText)findViewById(R.id.editUser);
        editPassword =(EditText)findViewById(R.id.editPassword);
        btnOk = (Button)findViewById(R.id.btnOk);
        register=(EditText)findViewById(R.id.register);
    }
    public void setEvent(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
      btnOk.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              callApi();

          }
      });
    }

    private  void callApi(){

        ApiService.API_SERVICE.convertUser(editUser.getText().toString()).enqueue(new Callback<Users>() {

            @Override
            public void onResponse(Call<Users> call, Response<Users> response ) {
                Toast.makeText(getApplicationContext(), "Thành công", Toast.LENGTH_LONG).show();

               Users customerTest  = response.body();
               if(customerTest != null ) {
                   if (editUser.getText().toString().equals(customerTest.getUserName()) && editPassword.getText().toString().equals(customerTest.getPassword())) {
                       Toast.makeText(getApplicationContext(), "login ok", Toast.LENGTH_SHORT).show();
                       if(customerTest.getRoleName().equals("Customer")){
                       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                       intent.putExtra("name",customerTest.getUserName());
                       startActivity(intent);}
                       else {
                             Intent intent1 = new Intent(getApplicationContext(),ChartActivity.class);
                             startActivity(intent1);
                       }
                   } else
                       Toast.makeText(getApplicationContext(), "login ko thnh công", Toast.LENGTH_SHORT).show();

               }else
                   Toast.makeText(getApplicationContext(), "ko có user", Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
            }
        });

    }
}