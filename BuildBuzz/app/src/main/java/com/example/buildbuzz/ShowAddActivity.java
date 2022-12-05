package com.example.buildbuzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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

public class ShowAddActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference databaseReference;
    private String siteId;
    private List<Site> siteList;
    private CustomAdapter customAdapter;
    //TextView id_name_one, id_roadCloased_one;
    TextView id_construction,id_road,id_type,id_location;
    public static  String userkey = "userkey";
     int val=0;

    public ImageButton btn_add, btn_home, btn_save, btn_map, btn_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_add);
        //^^^^^Alex call button ^^^^^^^^^^^^^
        callButton();
        id_construction = findViewById(R.id.id_construction);
        id_road = findViewById(R.id.id_road);
        id_type = findViewById(R.id.id_type);
        id_location = findViewById(R.id.id_location);

        Intent intent = getIntent();
        userkey = intent.getStringExtra(MainActivity.userkey);

        Bundle bundle = getIntent().getExtras();

        siteId = getIntent().getExtras().get("siteID").toString();

        //    String str="NHHFOMHSd8tL16Tu9r3";
        //  databaseReference= FirebaseDatabase.getInstance().getReference("site");
        String value = bundle.getString("siteID");

        userkey = bundle.getString("userkey", userkey);
        databaseReference = FirebaseDatabase.getInstance().getReference("site").child(userkey);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                id_construction.setText(userkey);
                Toast.makeText(ShowAddActivity.this, "Successful", Toast.LENGTH_SHORT).show();

                String name1 = snapshot.child("name").getValue().toString();
                String road1 = snapshot.child("roadClosed").getValue().toString();
                String type1 = snapshot.child("type").getValue().toString();
                String location1 = snapshot.child("location").getValue().toString();

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


    //^^^^^Alex call button ^^^^^^^^^^^^^
    private void callButton() {
        // Assign Button Value
        //  btn_add=findViewById(R.id.btn_add);
        btn_home = findViewById(R.id.btn_home);
        btn_map = findViewById(R.id.btn_map);
        btn_save = findViewById(R.id.btn_save);
        btn_setting = findViewById(R.id.btn_setting);
// Set onclick listener
        //   btn_add.setOnClickListener(this);
        btn_home.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_map.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_home:
                Intent intent2 = new Intent(ShowAddActivity.this, MainActivity.class);
                startActivity(intent2);
            case R.id.btn_map:
                Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn_save:
                Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_setting:
                Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}