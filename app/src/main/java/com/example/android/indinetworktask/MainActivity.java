package com.example.android.indinetworktask;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public String[] subjects = {"Science", "Maths", "English", "PET", "Music", "Hindi", "NCIT", "Social Science"};
    public String[] periods = {"period1", "period2", "period3", "period4", "period5", "period6", "period7", "period8"};
    public String[] backgroundColor = {"#ffd54f", "#66bb6a", "#ef5350", "#3f51b5", "#5c6bc0", "#ff7043", "#ab47bc", "#689f38"};
    public String[] spl_sub = {"science", "maths"};
    public String[] spl_period = {"Special Class 1", "Special Class 2"};
    public String[] spl_bgcolor = {"#4527a0", "#ec407a"};
    CalendarView calendarView;
    TextView tv_date;
    GridView gv_periods, gv_splclass;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (CalendarView) findViewById(R.id.cv_calendar);
        tv_date = (TextView) findViewById(R.id.tv_date);
        gv_periods = (GridView) findViewById(R.id.gv_period);
        gv_splclass = (GridView) findViewById(R.id.gv_spl_class);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                String[] days = new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Sarurday"};
                String dayOfWeek = days[calendar.get(Calendar.DAY_OF_WEEK)];
                tv_date.setText(dayOfWeek + " " + day);
            }
        });
        gv_periods.setAdapter(new GridviewAdapter(this, subjects, periods, backgroundColor));
        gv_splclass.setAdapter(new GridviewAdapter(this, spl_sub, spl_period, spl_bgcolor));


    }
}
