package com.example.akash.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Pass;
    private Button Login;
    private TextView ureg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name =(EditText)findViewById(R.id.n1);
        Pass =(EditText)findViewById(R.id.p1);
        Login =(Button) findViewById(R.id.b1);
        ureg=(TextView) findViewById(R.id.t1);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid(Name.getText().toString(), Pass.getText().toString());
            }
        });
        ureg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity .this, reg.class));
            }
        });


    }
    private void  valid(String userName, String pswd){
        if((userName.equals ("akash")) && (pswd.equals ("123"))){
            Intent intent = new Intent(MainActivity.this,Calender.class);
            Log.e("intent" ,"passed");
            startActivity(intent);
        }

        }
    }

