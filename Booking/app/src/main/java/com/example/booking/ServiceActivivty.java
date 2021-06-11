package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.Adapter.ServiceAdapter;
import com.example.booking.Adapter.ServiceListAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.Model.Service;
import com.example.booking.Model.Service_detail;
import com.google.android.gms.common.api.Api;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceActivivty extends AppCompatActivity {
    BottomNavigationView navigationView;
    ListView lvService;
    List<Service> listService;
    ServiceListAdapter adapter;
    Service_detail detail;
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_activivty);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Service");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent myintent = getIntent();
        name= myintent.getStringExtra("name");
        Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();
    detail = new Service_detail();
        navigationView = (BottomNavigationView) findViewById(R.id.bottom);
        lvService = (ListView) findViewById(R.id.lvService);
        listService = new ArrayList<>();
        getService();
        navigationView.setSelectedItemId(R.id.nav_service);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
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

    public void diaLogOrder(String servicename, int price){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_service);

        TextView tvService = (TextView) dialog.findViewById(R.id.tvService);
        EditText edtCount = (EditText) dialog.findViewById(R.id.edtCount);
        Button btnCheckout = (Button) dialog.findViewById(R.id.btnCheckout);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        tvService.setText(servicename);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail.setNameService(servicename);
                detail.setQuantity(Integer.parseInt(edtCount.getText().toString()));
                detail.setPrice(price);
                detail.setUsername(name);
                PostService();
                dialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void setAdapter(){
        adapter = new ServiceListAdapter(this, R.layout.custom_listview_service, listService);
        lvService.setAdapter(adapter);
    }

    public void PostService(){
        ApiService.API_SERVICE.PostService(detail).enqueue(new Callback<Service_detail>() {
            @Override
            public void onResponse(Call<Service_detail> call, Response<Service_detail> response) {
                Toast.makeText(getApplicationContext()," no", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Service_detail> call, Throwable t) {
                Toast.makeText(getApplicationContext()," Chọn dịch vụ thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getService(){
        ApiService.API_SERVICE.GetListService().enqueue(new Callback<List<Service>>() {
            @Override
            public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
                listService = response.body();
                setAdapter();
                Toast.makeText(getApplicationContext()," ok", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Service>> call, Throwable t) {
                Toast.makeText(getApplicationContext()," no", Toast.LENGTH_SHORT).show();
            }
        });
    }
}