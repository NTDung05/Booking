package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1, 100));
        barEntries.add(new BarEntry(2, 200));
        barEntries.add(new BarEntry(3, 333));
        barEntries.add(new BarEntry(4, 456));
        barEntries.add(new BarEntry(5, 54));
        barEntries.add(new BarEntry(6, 64));
        barEntries.add(new BarEntry(7, 74));
        barEntries.add(new BarEntry(8, 84));
        barEntries.add(new BarEntry(9, 94));
        barEntries.add(new BarEntry(10, 104));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Tháng");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Doanh Thu");
        barChart.animateY(200);
    }
}