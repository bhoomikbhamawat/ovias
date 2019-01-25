package com.example.akash.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Fpasswd extends AppCompatActivity {
    private EditText Umail;
    private Button fpswd1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpasswd);
        Umail=(EditText)findViewById(R.id.Umail);
        fpswd1=(Button) findViewById(R.id.fpswd1);
        firebaseAuth = FirebaseAuth.getInstance();

        fpswd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.sendPasswordResetEmail(Umail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Fpasswd.this,"Check your Mail",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Fpasswd.this,"Invalid E-Mail id",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

    }
}
