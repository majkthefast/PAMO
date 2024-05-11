package com.example.bmicalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class BmiChartActivity extends AppCompatActivity {

    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_chart);

        chart = findViewById(R.id.chart);
        setupChart();
    }

    private void setupChart() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 22f));
        entries.add(new Entry(2, 23f));
        entries.add(new Entry(3, 24f));

        LineDataSet dataSet = new LineDataSet(entries, "BMI");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
