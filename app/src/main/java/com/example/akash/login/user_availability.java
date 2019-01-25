package com.example.akash.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class user_availability extends AppCompatActivity {
    private TextView tv1;
    private RecyclerView recview;
    private int[] image ={R.drawable.activa,R.drawable.avg,R.drawable.mastero,R.drawable.shine,R.drawable.download,R.drawable.pulsar};
    private Adaptor adaptor;


    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_availability);

        recview =(RecyclerView)findViewById(R.id.recview);
        layoutManager =new LinearLayoutManager(this);
        recview.setLayoutManager(layoutManager);
        adaptor=new Adaptor(image,getApplicationContext());
        recview.setAdapter(adaptor);

    }
}
