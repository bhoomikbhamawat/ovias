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
    private Button lout;
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
               date= day +"/"+ mon+1 +"/"+ y;
                Log.d( "onSelectedDayChange" ,date);
                d1.setText(date);




            }

        });
        fbase =FirebaseAuth.getInstance();
        lout=(Button)findViewById(R.id.out);

        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbase.signOut();
                finish();
                Intent intent =new Intent(Calender.this,MainActivity.class);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutmenu:{
                logout();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;



    }



}
