package com.example.checkinsmart;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.ArchTaskExecutor;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class PieChartActivity extends AppCompatActivity {
    MyDatabaseHelper2 myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        myDB = new MyDatabaseHelper2(PieChartActivity.this);

        String po = getIntent().getStringExtra("pos");

        Calendar Calender = null;
        Date dateAndTime = Calender.getInstance().getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        String date = dateFormat.format(dateAndTime);

        Cursor cursor = myDB.readAllData(po,date);

        int count = 0;

        while (cursor.moveToNext()){

           count++;

        }

        Toast.makeText(this, "Welcome "+count, Toast.LENGTH_SHORT).show();

        Pie pie = AnyChart.pie();

        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                Toast.makeText(PieChartActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        });



        ArrayList<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("On Time", 10));
        data.add(new ValueDataEntry("Absence", 5));
        data.add(new ValueDataEntry("Late",3 ));
        data.add(new ValueDataEntry("Remaining Days",15 ));
        pie.data(data);

        pie.title("Your Attendance Overview");

        pie.labels().position("outside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Overview For This Month")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        anyChartView.setChart(pie);
    }
}