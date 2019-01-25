package com.example.akash.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Calender extends AppCompatActivity {
    private TextView d1;
    private CalendarView mCalendar;
    private Button procced;
    int mon1;
    String date;
    private FirebaseAuth fbase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        d1=(TextView)findViewById(R.id.dat);

        mCalendar=(CalendarView)findViewById(R.id.calendar);

        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int y, int mon, int day) {
                mon1=mon +1;
               date= day +"/"+mon1 +"/"+ y;
                Log.d( "onSelectedDayChange" ,date);
                d1.setText(date);




            }

        });
        fbase =FirebaseAuth.getInstance();
        procced=(Button)findViewById(R.id.proceed);

        procced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Calender.this,user_availability.class);
                startActivity(intent);
            }
        });


    }
    private void logout(){
        fbase.signOut();
        finish();
        Intent intent =new Intent(Calender.this,MainActivity.class);
        startActivity(intent);

    }
    private void adminin(){


        Intent intent =new Intent(Calender.this,Availability.class);
        startActivity(intent);}


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logoutmenu: {
                logout();
            }
        }switch(item.getItemId()){

                case R.id.admin:{
                    adminin();}




    }return super.onOptionsItemSelected(item);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;



    }



}
