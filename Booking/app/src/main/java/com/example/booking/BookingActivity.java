package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.rtt.CivicLocationKeys;
import android.os.Bundle;
import android.security.identity.CipherSuiteNotSupportedException;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.booking.Adapter.RoomAdapter;
import com.example.booking.Api.ApiService;

import com.example.booking.Model.Room;
import com.example.booking.Model.Room_type;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.UnaryOperator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {

    Button btnSearch;
    EditText edngaydat, edngaytra;
    Spinner spTypeRoom;
    ListView lvRoom;
    RoomAdapter customAdapter;
    final Calendar myCalendar = Calendar.getInstance();
    private int lastSelectedYear = myCalendar.get(Calendar.YEAR);
    private int lastSelectedMonth = myCalendar.get(Calendar.MONTH);
    private int lastSelectedDayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH);

    int date = myCalendar.get(Calendar.DAY_OF_WEEK);
    String recieveAt = "";
            String backAt ="" ;
    private int lastSelectedDayOfMonthnt = lastSelectedDayOfMonth + 1;
    private List<Room_type> room;
    String type[] = {"Tất cả", "Phòng 1 Giường", "Phòng 2 Giường", "Phòng 3 Giường", "Phòng 4 Giường", "Phòng 5 Giường"};
    int count = 0; //lấy loai phong cua spinner đẻ gán cho listview
    private List<Room_type> room2;
    private List<Room_type> room1;
    private List<Room_type> room3;
    private List<Room_type> room4;
    private List<Room_type> room5;
String name ="";
BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        room = new ArrayList<>();
        room2 = new ArrayList<>();
        room3 = new ArrayList<>();
        room1 = new ArrayList<>();
        room4 = new ArrayList<>();
        room5 = new ArrayList<>();

        Intent myintent = getIntent();
        name = myintent.getStringExtra("name");

        setContentView(R.layout.activity_booking);
//        room = new ArrayList<>();

        setControl();
        callApiRoom();
        setAdapterSpinner();


        if (count == 0) {
            setAdapter(room);

        }
//
        setEvent();
    }

    public void sort() {
        for (int i = 0; i < room.size(); i++) {
            if (room.get(i).getNumber_of_bed() == 1) {
                room1.add(room.get(i));
            }
            if (room.get(i).getNumber_of_bed() == 2) {
                room2.add(room.get(i));
            }
            if (room.get(i).getNumber_of_bed() == 3) {
                room3.add(room.get(i));
            }
            if (room.get(i).getNumber_of_bed() == 4) {
                room4.add(room.get(i));
            }
            if (room.get(i).getNumber_of_bed() == 5) {
                room5.add(room.get(i));
            }
        }
    }

    public void delete() {
        room1.clear();
        room2.clear();
        room3.clear();
        room4.clear();
        room5.clear();

    }



    private void setControl() {
        btnSearch = (Button) findViewById(R.id.btnSearch);
        spTypeRoom = (Spinner) findViewById(R.id.spTypeRoom);
        lvRoom = (ListView) findViewById(R.id.lvRoom);
        edngaydat = (EditText) findViewById(R.id.edNgaydat);
        edngaytra = (EditText) findViewById(R.id.edNgaytra);
        navigationView = (BottomNavigationView) findViewById(R.id.bottom);
    }


    public void setEvent() {
        navigationView.setSelectedItemId(R.id.nav_booking);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case R.id.nav_booking:
                        Intent intent1 = new Intent(getApplicationContext(), BookingActivity.class);
                        intent1.putExtra("name",name);
                        startActivity(intent1);
                        break;
                    case R.id.nav_service:
                        Intent intent2 = new Intent(getApplicationContext(), ServiceActivivty.class);
                        intent2.putExtra("name",name);
                        startActivity(intent2);
                        break;
                    case R.id.nav_cart:
                        Intent intent3 = new Intent(getApplicationContext(), CartActivity.class);
                        intent3.putExtra("name",name);
                        startActivity(intent3);
                        break;
                    case R.id.nav_account:
                        Intent intent4 = new Intent(getApplicationContext(), ProfileActivity.class);
                        intent4.putExtra("name",name);
                        startActivity(intent4);
                        break;
                }


                return true;
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (room != null) {
                    delete();
                }
                callApiRoom();


            }


        });

        edngaydat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        edngaydat.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//                        Date now = new Date();
//                        int date = myCalendar.get(Calendar.DAY_OF_WEEK);
//
                          recieveAt = year + "-"+ (monthOfYear+1)+"-"+dayOfMonth;
                        lastSelectedYear = year;
                        lastSelectedMonth = monthOfYear;
                        lastSelectedDayOfMonth = dayOfMonth;
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, monthOfYear, dayOfMonth);
                        date = cal.get(Calendar.DAY_OF_WEEK);

                    }
                };

                DatePickerDialog datePickerDialog = null;
                datePickerDialog = new DatePickerDialog(BookingActivity.this,
                        dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
                datePickerDialog.show();


            }
        });
        edngaytra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        edngaytra.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        backAt = year + "-"+ (monthOfYear+1)+"-"+dayOfMonth;
                        lastSelectedYear = year;
                        lastSelectedMonth = monthOfYear;
                        lastSelectedDayOfMonthnt = dayOfMonth;
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, monthOfYear, dayOfMonth);

                    }
                };

                DatePickerDialog datePickerDialog = null;
                datePickerDialog = new DatePickerDialog(BookingActivity.this,
                        dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonthnt);
                datePickerDialog.show();

            }
        });

        spTypeRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                count = position;
                System.out.print("hihihihihihihihih" + count);
                if (count == 1) {
                    setAdapter(room1);
                    lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Room_type test1 = room1.get(position);
                            if(recieveAt == null || backAt ==null){
                                Toast.makeText(getApplicationContext(),"Hãy chọn ngày nhận và ngày trả phòng",Toast.LENGTH_SHORT).show();
                            }else {
                            Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("test1", test1);
                            bundle.putString("recieveAt",recieveAt);
                            bundle.putString("backAt",backAt);
                            bundle.putString("name",name);
                            intent.putExtras(bundle);
                            startActivity(intent);}
                        }
                    });
                } else if (count == 2) {
                    setAdapter(room2);
                    lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Room_type test1 = room2.get(position);
                            if(recieveAt == null || backAt ==null){
                                Toast.makeText(getApplicationContext(),"Hãy chọn ngày nhận và ngày trả phòng",Toast.LENGTH_SHORT).show();
                            }else {
                                Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("test1", test1);
                                bundle.putString("recieveAt",recieveAt);
                                bundle.putString("backAt",backAt);
                                bundle.putString("name",name);
                                intent.putExtras(bundle);
                                startActivity(intent);}
                        }

                    });
                } else if (count == 3) {
                    setAdapter(room3);
                    lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Room_type test1 = room3.get(position);
                            if(recieveAt == null || backAt ==null){
                                Toast.makeText(getApplicationContext(),"Hãy chọn ngày nhận và ngày trả phòng",Toast.LENGTH_SHORT).show();
                            }else {
                                Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("test1", test1);
                                bundle.putString("recieveAt",recieveAt);
                                bundle.putString("backAt",backAt);
                                bundle.putString("name",name);
                                intent.putExtras(bundle);
                                startActivity(intent);}
                        }
                    });
                } else if (count == 4) {
                    setAdapter(room4);
                    lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Room_type test1 = room4.get(position);
                            if(recieveAt == null || backAt ==null){
                                Toast.makeText(getApplicationContext(),"Hãy chọn ngày nhận và ngày trả phòng",Toast.LENGTH_SHORT).show();
                            }else {
                                Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("test1", test1);
                                bundle.putString("recieveAt",recieveAt);
                                bundle.putString("backAt",backAt);
                                bundle.putString("name",name);
                                intent.putExtras(bundle);
                                startActivity(intent);}
                        }
                    });
                } else if (count == 5) {
                    setAdapter(room5);
                    lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Room_type test1 = room5.get(position);
                            if(recieveAt == null || backAt ==null){
                                Toast.makeText(getApplicationContext(),"Hãy chọn ngày nhận và ngày trả phòng",Toast.LENGTH_SHORT).show();
                            }else {
                                Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("test1", test1);
                                bundle.putString("recieveAt",recieveAt);
                                bundle.putString("backAt",backAt);
                                bundle.putString("name",name);
                                intent.putExtras(bundle);
                                startActivity(intent);}
                        }
                    });
                } else {
                    setAdapter(room);
                    lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Room_type test1 = room.get(position);
                            if(recieveAt == null || backAt ==null){
                                Toast.makeText(getApplicationContext(),"Hãy chọn ngày nhận và ngày trả phòng",Toast.LENGTH_SHORT).show();
                            }else {
                                Intent intent = new Intent(getApplicationContext(), RoomDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("test1", test1);
                                bundle.putString("recieveAt",recieveAt);
                                bundle.putString("backAt",backAt);
                                bundle.putString("name",name);
                                intent.putExtras(bundle);
                                startActivity(intent);}
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void updateSpinner() {
        count = spTypeRoom.getSelectedItemPosition();
        int count1 = spTypeRoom.getSelectedItemPosition();
        String c = String.valueOf(count1);
        Toast.makeText(getApplicationContext(), c, Toast.LENGTH_SHORT).show();
        if (count == 1) {
            setAdapter(room1);
            Toast.makeText(getApplicationContext(), "122", Toast.LENGTH_SHORT).show();
        } else if (count1 == 2) {
            setAdapter(room2);
            Toast.makeText(getApplicationContext(), "125", Toast.LENGTH_SHORT).show();
        } else if (count1 == 3) {
            setAdapter(room3);
        } else if (count1 == 4) {
            setAdapter(room4);
        } else if (count1 == 5) {
            setAdapter(room5);
        }

    }

    private void callApiRoom() {

        ApiService.API_SERVICE.GetListTypeRoom(date).enqueue(new Callback<List<Room_type>>() {
            @Override
            public void onResponse(Call<List<Room_type>> call, Response<List<Room_type>> response) {
                List<Room_type> temp1 = new ArrayList<>();
                room = response.body();
                sort();
                updateSpinner();
            }

            @Override
            public void onFailure(Call<List<Room_type>> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<Room_type> r) {
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

