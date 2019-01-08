package com.example.akash.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class Calender extends AppCompatActivity {
    private TextView d1;
    private CalendarView mCalendar;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        d1=(TextView)findViewById(R.id.dat);

        mCalendar=(CalendarView)findViewById(R.id.calendar);

        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int y, int mon, int day) {
               date= day +"/"+ mon+1 +"/"+ y;
                Log.d( "onSelectedDayChange" ,date);
                d1.setText(date);


            }

        });

    }

}
