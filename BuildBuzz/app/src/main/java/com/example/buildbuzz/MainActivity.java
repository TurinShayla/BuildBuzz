package com.example.buildbuzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
ImageButton btn_add,btn_home,btn_save,btn_map,btn_setting;
    private ListView listView;
    private List<Site> siteList;
    private CustomAdapter customAdapter;
    TextView id_name_one, id_roadCloased_one;
    int val=0;

    public static  String userkey = "user key";
    LinearLayout id_layout_sample;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callButton();

        databaseReference= FirebaseDatabase.getInstance().getReference("site");
        siteList=new ArrayList<>(); //list
        customAdapter=new CustomAdapter(MainActivity.this,siteList);//presAdapter

        listView=findViewById(R.id.id_list_all);
        id_layout_sample=findViewById(R.id.id_layout_one);
        id_name_one=findViewById(R.id.id_name_one);
        id_roadCloased_one=findViewById(R.id.id_roadClosed_one);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String currentSite=adapterView.getItemAtPosition(position).toString();
                Site model=siteList.get(position);
                Intent intent3=new Intent(MainActivity.this,ShowAddActivity.class);
            //    Intent intent3=new Intent(getContext(),ShowAddActivity.class);

                intent3.putExtra("siteID",currentSite);
                intent3.putExtra(userkey,model.getUserKey());
                //intent3.putExtra(userkey,currentSite.get);
                startActivity(intent3);
            }
        });
    }

    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               //blogModelList
                siteList.clear();
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    //BlogModel(Site) blogModel (site)
                    Site site=snapshot1.getValue((Site.class));
                    siteList.add(site);
                }
                listView.setAdapter(customAdapter); //blogAdapter
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }


    private void callButton() {
        // Assign Button Value
        btn_add=findViewById(R.id.btn_add);
        btn_home=findViewById(R.id.btn_home);
        btn_map=findViewById(R.id.btn_map);
        btn_save=findViewById(R.id.btn_save);
        btn_setting=findViewById(R.id.btn_setting);
// Set onclick listener
        btn_add.setOnClickListener(this);
        btn_home.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_map.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_add:
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_home:
                Intent intent2=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent2);
            case R.id.btn_map:
                Toast.makeText(this,"Under Construction",Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn_save:
                Toast.makeText(this,"Under Construction",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_setting:
                Toast.makeText(this,"Under Construction",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}