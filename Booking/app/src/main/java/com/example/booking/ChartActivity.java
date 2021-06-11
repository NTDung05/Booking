package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.Api.ApiService;
import com.example.booking.Model.Month;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartActivity extends AppCompatActivity {
Button btnBarChart,btnPieChart;
Month month;
    EditText edtYear;
    String year=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        month = new Month();
        setControl();
        setEvent();



    }
    private void setControl(){
        btnBarChart = (Button)findViewById(R.id.btnBarChart);
        btnPieChart =(Button)findViewById(R.id.btnPieChart);
        edtYear = (EditText)findViewById(R.id.edtYear);

    }



    private  void setEvent(){
        year=edtYear.getText().toString();
        btnPieChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=edtYear.getText().toString();


                Intent intent = new Intent(getApplicationContext(),PieChartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("year", year);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnBarChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year=edtYear.getText().toString();


                Intent intent = new Intent(getApplicationContext(),BarChartActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString("year", year);
               intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

}