package com.example.akash.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Availability extends AppCompatActivity {
    private Button abtn1;
    private EditText av1;
    private TextView t4;
    private EditText av2;
    private EditText av4;
    private EditText av3;
    private EditText av5;
    private EditText av6;
    private Button abtn2;
    private Button abtn4;

    public String avail1;
    public String avail2;

    private Button abtn5;
    private Button abtn6;
    private Button abtn3;
    //firebase
    FirebaseDatabase fdbase;
    DatabaseReference dref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);
        av1=(EditText)findViewById(R.id.av1);
        av3=(EditText)findViewById(R.id.av3);
        av4=(EditText)findViewById(R.id.av4);
        av6=(EditText)findViewById(R.id.av6);
        abtn1=(Button)findViewById(R.id.abtn1);
        av5=(EditText)findViewById(R.id.av5);
        av2=(EditText)findViewById(R.id.av2);
        abtn2=(Button)findViewById(R.id.abtn2);
        abtn4=(Button)findViewById(R.id.abtn4);
        abtn5=(Button)findViewById(R.id.abtn5);
        abtn6=(Button)findViewById(R.id.abtn6);
        fdbase= FirebaseDatabase.getInstance();
        dref = fdbase.getReference();
        abtn2=(Button)findViewById(R.id.abtn2);
        abtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avail1=av1.getText().toString();

                dref.child("Activa").child("avail").setValue(avail1);
                dref.child("Activa").child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        abtn3=(Button)findViewById(R.id.abtn3);
        abtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avail2=av2.getText().toString();
                dref.child("Avengers").child("avail").setValue(avail2)
                ;
                dref.child("Avengers").child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        abtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avail2=av2.getText().toString();
                dref.child("Mastero").child("avail").setValue(avail2)
                ;
                dref.child("Mastero").child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        abtn4=(Button)findViewById(R.id.abtn3);
        abtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avail2=av4.getText().toString();
                dref.child("Shine").child("avail").setValue(avail2)
                ;
                dref.child("Shine").child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        abtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avail2=av2.getText().toString();
                dref.child("Splender").child("avail").setValue(avail2)
                ;
                dref.child("Splender").child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        abtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avail2=av2.getText().toString();
                dref.child("pulsar").child("avail").setValue(avail2)
                ;
                dref.child("pulsar").child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

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


}
