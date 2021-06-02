package com.example.booking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.booking.Adapter.RoomAdapter;
import com.example.booking.Model.Price;
import com.example.booking.Model.Room;
import com.example.booking.Model.Room_type;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    Button btnSearch;
    EditText edngaydat, edngaytra;
    Spinner spTypeRoom;
    ListView lvRoom ;
    RoomAdapter customAdapter;
private List<Room> room ;
    String type[] = {"Tất cả","Phòng Đơn","Phòng Đôi", "Phòng Master"} ;
    int count=0 ; //lấy loai phong cua spinner đẻ gán cho listview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Room_type t1 = new Room_type(1, 1);  //Phòng đơn
        Room_type t2 = new Room_type(2, 2); //Phòng đôi
        Room_type t3 = new Room_type(3, 3); // Phòng Mster
        Price p1 = new Price(t1,1, 5000);
        Price p2 = new Price(t3 ,0, 2000);
        Room r = new Room("101", t1, "View Biến",
                "https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg",1);
        Room r1 = new Room("102", t1, "View Biến",
                "https://www.italianbark.com/wp-content/uploads/2018/01/hotel-room-design-trends-italianbark-interior-design-blog.jpg",1);
        Room r2 = new Room("103", t3, "View Núi",
                "https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg",1);
        Room r3 = new Room("104", t2, "View Biến",
                "https://imgur.com/a/Lz5ibqc",1);
     room =new ArrayList<>();
         room.add(r);
        room.add(r1);
        room.add(r2);
        room.add(r3);
        List<Room> room2 = new ArrayList<>();
        List<Room> room1 = new ArrayList<>();
        List<Room> room3 = new ArrayList<>();
         for(int i = 0; i < room.size();i++){
             if(room.get(i).getType().getNumber_of_bed()==1){
                 room1.add(room.get(i));
             }
             if(room.get(i).getType().getNumber_of_bed()==2){
                 room2.add(room.get(i));
             }
             if(room.get(i).getType().getNumber_of_bed()==3){
                 room3.add(room.get(i));
             }
         }
        setContentView(R.layout.activity_booking);

        setControl();
        setAdapterSpinner();
        if(count == 0){
        setAdapter(room);}


        setEvent(room1, room2, room3);
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
        edngaydat = (EditText)findViewById(R.id.edNgaydat);
        edngaytra = (EditText)findViewById(R.id.edNgaytra);
    }

    public void setEvent(List<Room> room1, List<Room> room2,List<Room> room3){
   btnSearch.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

       }
   });
   

   spTypeRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          count = position;
          System.out.print("hihihihihihihihih"+count);
            if(count ==1){ setAdapter(room1);
                lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         Room test1 = room1.get(position);
                        Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("test1", test1);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
           else if(count == 2) {setAdapter(room2);
                lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Room test1 = room2.get(position);
                        Intent intent = new Intent(getApplicationContext(),RoomDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("test1", test1);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });}
           else if(count == 3) {setAdapter(room3);
                lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Room test1 = room3.get(position);
                        Intent intent = new Intent(getApplicationContext(),RoomDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("test1", test1);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });}
           else {setAdapter(room);
                lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Room test1 = room.get(position);
                        Intent intent = new Intent(getApplicationContext(),RoomDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("test1", test1);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
           }
       }

       @Override
       public void onNothingSelected(AdapterView<?> parent) {

       }
   });


    }


    private void setAdapter(List<Room> r) {
       // (customAdapter == null) {
            customAdapter = new RoomAdapter(this, R.layout.custom_list_view_room, r);
            lvRoom.setAdapter(customAdapter);

      //  } else {
        //    customAdapter.notifyDataSetChanged();
          //  lvRoom.setSelection(customAdapter.getCount() - 1);
        //}
    }
    private void setAdapterSpinner() {
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spTypeRoom.setAdapter(adapter);
    }
}