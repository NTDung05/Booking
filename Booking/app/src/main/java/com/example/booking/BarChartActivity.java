package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.security.identity.AccessControlProfileId;
import android.widget.Toast;

import com.example.booking.Api.ApiService;
import com.example.booking.Model.Month;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BarChartActivity extends AppCompatActivity {
    ArrayList<BarEntry> barEntries;
private Month month;
    String year=" ";
    BarChart barChart;
    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        barChart = (BarChart)findViewById(R.id.barChart);
        barEntries = new ArrayList<>();
        month = new Month();
        Intent myintent = getIntent();
        Bundle bundle = myintent.getExtras();
        year = bundle.getString("year");
        int t = Integer.parseInt(year);
        DoanhThu(t);




    }
public void set(){
    barEntries.add(new BarEntry(1, getMonth().getTh1()));
    barEntries.add(new BarEntry(2, getMonth().getTh2()));
    barEntries.add(new BarEntry(3, getMonth().getTh3()));
    barEntries.add(new BarEntry(4, getMonth().getTh4()));
    barEntries.add(new BarEntry(5, getMonth().getTh5()));
    barEntries.add(new BarEntry(6, getMonth().getTh6()));
    barEntries.add(new BarEntry(7, getMonth().getTh7()));
    barEntries.add(new BarEntry(8, getMonth().getTh8()));
    barEntries.add(new BarEntry(9, getMonth().getTh9()));
    barEntries.add(new BarEntry(10, getMonth().getTh10()));
    barEntries.add(new BarEntry(11, getMonth().getTh11()));
    barEntries.add(new BarEntry(12, getMonth().getTh12()));
    BarDataSet barDataSet = new BarDataSet(barEntries, "Tháng");
    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
    barDataSet.setValueTextColor(Color.BLACK);
    barDataSet.setValueTextSize(16f);

    BarData barData = new BarData(barDataSet);

    barChart.setFitBars(true);
    barChart.setData(barData);
    barChart.getDescription().setText("Doanh Thu");
    barChart.animateY(10000);
}
    private void DoanhThu(int y){
        ApiService.API_SERVICE.GetChart(y).enqueue(new Callback<Month>() {
            @Override
            public void onResponse(Call<Month> call, Response<Month> response) {
             month = response.body();
               set();
            }

            @Override
            public void onFailure(Call<Month> call, Throwable t) {

            }
        });
    }
}