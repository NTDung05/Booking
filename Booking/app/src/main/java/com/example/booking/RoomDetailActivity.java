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
import com.squareup.picasso.Picasso;

public class RoomDetailActivity extends AppCompatActivity {
    Room room;
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
            room = (Room) bundle.getSerializable("test1");
            price = (Price)bundle.getSerializable("price1");
        }
        setContentView(R.layout.activity_room_detail);
        setControl();
        setEvent(room);
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
private  void setEvent(Room room){
    Picasso.with(getApplicationContext())
            .load(room.getAvatar())
            .into(imgAva1);
    if(room.getType().getNumber_of_bed()==1){
        tvLoaiPhong1.setText("Phòng Đơn");
    };
    if(room.getType().getNumber_of_bed()==2){
        tvLoaiPhong1.setText("Phòng Đôi");
    };
    if(room.getType().getNumber_of_bed()==3){
        tvLoaiPhong1.setText("Phòng Master");
    };
    tvMota.setText("Mô tả: "+room.getDescription().toString());

    tvGia.setText("Giá: "+String.valueOf(price.getPrice())+" VNĐ");
    btThem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Chọn Phòng Thành Công", Toast.LENGTH_LONG).show();
        }
    });
}
}
