package com.example.akash.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Availability extends AppCompatActivity {
    private Button avbtn;
    private EditText av1;
    private TextView t4;
    private EditText av2;
    private Button abtn2;
    private Button abtn3;
    //firebase
    FirebaseDatabase fdbase;
    DatabaseReference dref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);
        av1=(EditText)findViewById(R.id.av1);
        t4=(TextView) findViewById(R.id.t4);
        av2=(EditText)findViewById(R.id.av2);
        fdbase= FirebaseDatabase.getInstance();
        dref = fdbase.getReference();
        abtn2=(Button)findViewById(R.id.abtn2);
        abtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String availi=av1.getText().toString();
                dref.child("-LWHryaso8KC8uSR9Azv").child("avail").setValue(availi);

            }
        });
        abtn3=(Button)findViewById(R.id.abtn3);
        abtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String availi=av2.getText().toString();
                dref.child("-LWHs-jFPAMGFFp3cop6").child("avail").setValue(availi)
                ;

            }
        });


        avbtn=(Button)findViewById(R.id.abtn1);
        avbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbikes();

            }
        });


    }
    private void addbikes(){
        String avail=av1.getText().toString();
        String id = dref.push().getKey();
        t4.setText(id); 

        bikes bike =new bikes(id,avail);
        dref.child(id).setValue(bike);
    }
    private void availbikes(){

    }

}
