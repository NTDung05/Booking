package com.example.booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.booking.Model.Customer;
import com.example.booking.Model.Price;
import com.example.booking.Model.Room;
import com.example.booking.Model.Room_type;
import com.squareup.picasso.Picasso;

public class RoomDetailActivity extends AppCompatActivity {
    Room_type room;
    Price price;
    ImageView imgAva1;
    TextView tvLoaiPhong1, tvMota, tvGia;
    Button btThem;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        if (bundle != null) {
            room = (Room_type) bundle.getSerializable("test1");

        }
        setContentView(R.layout.activity_room_detail);
        setControl();
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
private void setControl(){
   imgAva1 = (ImageView)findViewById(R.id.imgAva1);
   tvLoaiPhong1 = (TextView)findViewById(R.id.tvLoaiPhong1);
   tvMota = (TextView)findViewById(R.id.tvMota);
   btThem = (Button)findViewById(R.id.btThem);
   tvGia = (TextView)findViewById(R.id.tvGia);
}
private  void setEvent(){
    if(room.getName().equals("Superior")){
        Picasso.with(getApplicationContext())
                .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-02.jpg")
                .into(imgAva1);}
    if(room.getName().equals("Standard")){
        Picasso.with(getApplicationContext())
                .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-01.jpg")
                .into(imgAva1);}
    if(room.getName().equals("Deluxe")){
        Picasso.with(getApplicationContext())
                .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-03.jpg")
                .into(imgAva1);}
    if(room.getName().equals("Suite")){
        Picasso.with(getApplicationContext())
                .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-04.jpg")
                .into(imgAva1);}
    if(room.getName().equals("Suite")){
        Picasso.with(getApplicationContext())
                .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-05.jpg")
                .into(imgAva1);}
    tvLoaiPhong1.setText(room.getName());
    tvMota.setText("Mô tả: "+" Phòng có "+String.valueOf(room.getNumber_of_bed())+"giường "+"\n"+room.getDescription());

    tvGia.setText("Giá: "+String.valueOf(room.getPrice())+" VNĐ");
    btThem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Chọn Phòng Thành Công", Toast.LENGTH_LONG).show();
        }
    });
}
}
