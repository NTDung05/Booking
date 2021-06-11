package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.booking.Api.ApiService;
import com.example.booking.Model.Month;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PieChartActivity extends AppCompatActivity {
    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    String year=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

         pieChart =(PieChart) findViewById(R.id.pieChart);
        pieEntries = new ArrayList<>();
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        year = bundle.getString("year");
        int t = Integer.parseInt(year);
        DoanhThu(t);


    }
    public void set(){
        pieEntries.add(new PieEntry(10000000, "Phong xin vl"));
        pieEntries.add(new PieEntry(20000000, "Phong dom vl"));
        pieEntries.add(new PieEntry(30000000, "Phong cui vl"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Loại Phòng");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Doanh Thu Theo Loại Phòng");
        pieChart.animate();
    }
    private void DoanhThu(int y){
        ApiService.API_SERVICE.GetChart(y).enqueue(new Callback<Month>() {
            @Override
            public void onResponse(Call<Month> call, Response<Month> response) {
           //     month = response.body();
                set();
            }

            @Override
            public void onFailure(Call<Month> call, Throwable t) {

            }
        });
    }
}