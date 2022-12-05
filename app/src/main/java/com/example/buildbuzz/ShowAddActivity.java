package com.example.buildbuzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowAddActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    private String siteId;
    private List<Site> siteList;
    private CustomAdapter customAdapter;
    //TextView id_name_one, id_roadCloased_one;
    TextView id_construction,id_road,id_type,id_location;
    public static  String userkey = "userkey";
     int val=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_add);

        id_construction=findViewById(R.id.id_construction);
        id_road=findViewById(R.id.id_road);
        id_type=findViewById(R.id.id_type);
        id_location=findViewById(R.id.id_location);

        Intent intent=getIntent();
        userkey=intent.getStringExtra(MainActivity.userkey);

        Bundle bundle=getIntent().getExtras();

        siteId=getIntent().getExtras().get("siteID").toString();

    //    String str="NHHFOMHSd8tL16Tu9r3";
      //  databaseReference= FirebaseDatabase.getInstance().getReference("site");
        String value=bundle.getString("siteID");

        userkey=bundle.getString("userkey",userkey);
         databaseReference= FirebaseDatabase.getInstance().getReference("site").child(userkey);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                id_construction.setText(userkey);
                Toast.makeText(ShowAddActivity.this,"Successful",Toast.LENGTH_SHORT).show();

                String name1=snapshot.child("name").getValue().toString();
                String road1=snapshot.child("roadClosed").getValue().toString();
                String type1=snapshot.child("type").getValue().toString();
                String location1=snapshot.child("location").getValue().toString();

           //     TimePresShow.setText(TimePresShow1);
             //   MedShow.setText(MedShow1);
              //     String name1=snapshot.child("name").getValue().toString();
                //     String road1=snapshot.child("roadClosed").getValue().toString();
                //   String type1=snapshot.child("type").getValue().toString();
                //     String location1=snapshot.child("location").getValue().toString();
                  id_construction.setText(name1);
                id_road.setText(road1);
                id_type.setText(type1);
                id_location.setText(location1);
                         }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }
        }