package com.example.booking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.booking.Adapter.RoomAdapter;
import com.example.booking.Model.Room;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    Button btnSearch;
    Spinner spTypeRoom;
    ListView lvRoom ;
    RoomAdapter customAdapter;
private List<Room> room ;
    String type[] = {"Phòng Đôi","Phòng Đơn", "Phòng Master"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Room r = new Room("101",
                "Phòng Đôi",
                "View Biến",
                "https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg");
        Room r1 = new Room("102",
                "Phòng Đơn",
                "View Biến",
                "https://www.italianbark.com/wp-content/uploads/2018/01/hotel-room-design-trends-italianbark-interior-design-blog.jpg");
        Room r2 = new Room("103",
                "Phòng Master",
                "View Biến",
                "https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg");
        Room r3 = new Room("104",
                "Phòng Đôi",
                "View Biến",
                "https://imgur.com/a/Lz5ibqc");
     room =new ArrayList<>();
         room.add(r);
        room.add(r1);
        room.add(r2);
        room.add(r3);

        setContentView(R.layout.activity_booking);

        setControl();
        setAdapter();
        setAdapterSpinner();
        setEvent();
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
    private void setControl(){
        btnSearch = (Button) findViewById(R.id.btnSearch);
        spTypeRoom  = (Spinner) findViewById(R.id.spTypeRoom);
        lvRoom = (ListView) findViewById(R.id.lvRoom);
    }

    private void setEvent(){
   btnSearch.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

       }
   });
    }


    private void setAdapter() {
        if (customAdapter == null) {
            customAdapter = new RoomAdapter(this, R.layout.custom_list_view_room, room);
            lvRoom.setAdapter(customAdapter);

        } else {
            customAdapter.notifyDataSetChanged();
            lvRoom.setSelection(customAdapter.getCount() - 1);
        }
    }
    private void setAdapterSpinner() {
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spTypeRoom.setAdapter(adapter);
    }
}