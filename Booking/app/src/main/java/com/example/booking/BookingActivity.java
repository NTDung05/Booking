package com.example.booking;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class BookingActivity extends AppCompatActivity {

    Button btnSearch;
    Spinner spTypeRoom;
    ListView lvRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Booking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_booking);
        setControl();
        setEvent();
    }

    private void setControl(){
        btnSearch = (Button) findViewById(R.id.btnSearch);
        spTypeRoom  = (Spinner) findViewById(R.id.spTypeRoom);
        lvRoom = (ListView) findViewById(R.id.lvRoom);
    }

    private void setEvent(){

    }
}