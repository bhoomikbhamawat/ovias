package com.example.akash.login;

import android.app.LauncherActivity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.LastOwnerException;
import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.AdaptorViewholder> {
    private int[] image;
    private Context context;
    public FirebaseDatabase fdbase;
   public DatabaseReference dref;
   public String[] fire={"Activa","Avengers","Mastero","Shine","Splender","pulsar"};
    public Adaptor( int[] image,Context context){
        this.image =image;
        this.context=context;
        fdbase= FirebaseDatabase.getInstance();
        dref = fdbase.getReference();
    }
    @NonNull
    @Override
    public AdaptorViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bikeslists,viewGroup,false);
        return new AdaptorViewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptorViewholder adaptorViewholder, int i) {
        int condn =image[i];
//        adaptorViewholder.image.setImageResource(condn);
//        adaptorViewholder.txt.setText(i);
        adaptorViewholder.bindData(condn,i);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.bikeslists;
    }

    public class  AdaptorViewholder extends RecyclerView.ViewHolder{
        public  TextView txt;
        public ImageView images;

        public AdaptorViewholder(@NonNull View itemView) {
            super(itemView);
            txt =(TextView)itemView.findViewById(R.id.abdv2);
            images=(ImageView)itemView.findViewById(R.id.imV1);

        }
        void bindData(int image,int i)
        {
            images.setImageResource(image);
            txt.setText(String.valueOf(i));
            dref.child(fire[i]).child("avail").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    txt.setText(dataSnapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }




    }
}
