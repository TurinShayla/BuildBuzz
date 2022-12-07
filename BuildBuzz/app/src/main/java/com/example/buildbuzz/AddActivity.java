package com.example.buildbuzz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
private Spinner type_spinner,road_closed_Spinner;
private ImageView image1,image2;
private TextView textDate;
private EditText Input_name,Input_location;
private DatePicker btn_datePicker;
private ImageButton btn_date, btn_upload,btn_camera;
private DatePickerDialog datePickerDialog;
private AppCompatButton btn_submitAdd, btn_cancelAdd;
public String road;
Uri imageUri;
    ImageButton btn_add,btn_home,btn_save,btn_map,btn_setting;
//FirebaseDatabase rootNode;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        callButton();

        //**************** Database***********************
        databaseReference=FirebaseDatabase.getInstance().getReference("site");

        //******************************* Site Name ***************************************************
        Input_name=findViewById(R.id.Input_name);
        //******************************* Location ***************************************************
        Input_location=findViewById(R.id.Input_location);
        //******************************* Date Picker ***************************************************
        textDate=findViewById(R.id.textDate);
        btn_date=findViewById(R.id.btn_date);

    //******************************* DROP DOWN ***************************************************
        Method_dropDown();

    //******************************* Upload Photo ***************************************************
    btn_upload=findViewById(R.id.btn_upload);
    btn_camera=findViewById(R.id.btn_camera);
    //**************** Submit and Cancel **************************************************
        btn_submitAdd=findViewById(R.id.btn_submitAdd);
        btn_cancelAdd=findViewById(R.id.btn_cancelAdd);
        //************************ Set on click listner to the button **************
        btn_date.setOnClickListener(this);
        btn_upload.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_submitAdd.setOnClickListener(this);
        btn_cancelAdd.setOnClickListener(this);
    }

    //******************************* DROP DOWN ***************************************************
public void Method_dropDown(){
    road_closed_Spinner=findViewById(R.id.road_closed_Spinner);
    //    Input_road_closed_Spinner=findViewById(R.id.Input_road_closed_Spinner);
    String[] Select_drop={"Road Closed? ", "Road is closed", "Road is open"};
    ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,Select_drop);
    road_closed_Spinner.setAdapter(adapter2);
    road= String.valueOf(adapter2);

    type_spinner=findViewById(R.id.type_spinner);
    String[] Construction_type={"Select Construction Type", "Building", "Road", "Bridge"};
    ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,Construction_type);
    type_spinner.setAdapter(adapter);
}
    private void callButton() {
        // Assign Button Value

        btn_home=findViewById(R.id.btn_home);
        btn_map=findViewById(R.id.btn_map);
        btn_save=findViewById(R.id.btn_save);
        btn_setting=findViewById(R.id.btn_setting);
// Set onclick listener

        btn_home.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_map.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
    }

    //******************************* DatePicker ***************************************************
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_date:
                fixedDate();
                break; 
            case R.id.btn_upload:

              Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
               break;

            case R.id.btn_camera:
                Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_submitAdd:
                String name=Input_name.getText().toString().trim();

               // Toast.makeText(this, "Construction Site", Toast.LENGTH_SHORT).show();
                saveData();
                //Intent intent=new Intent(AddActivity.this,ShowAddActivity.class);
                //startActivity(intent);
                break;
            case R.id.btn_cancelAdd:
                Toast.makeText(this, "Home Page", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_home:
                Intent intent3=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent3);
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


    private void fixedDate() {
        DatePicker datePicker = new DatePicker(this);
        int currentDay = datePicker.getDayOfMonth();
        int currentMonth = (datePicker.getMonth()) + 1;
        int currentYear = datePicker.getYear();

        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        //  String k=setText((month + 1) + "/ " + dayOfMonth + " / " + year);

                        textDate.setText((month + 1) + "/ " + dayOfMonth + " / " + year);
                    }
                }, currentYear, currentMonth, currentDay);
        datePickerDialog.show();

    }

    public void saveData() {
        String name=Input_name.getText().toString().trim();
        String location=Input_location.getText().toString().trim();
        String tentativeDate=textDate.getText().toString().trim();
        String roadClosed=road_closed_Spinner.getSelectedItem().toString();
        String type=type_spinner.getSelectedItem().toString();
        String photos="Under Construction";
        String userkey="userkey?";

        //******** Set key the primary key ********************
        String key=databaseReference.push().getKey();
        Site site=new Site(name,location,tentativeDate,roadClosed,type,photos,key);
        databaseReference.child(key).setValue(site);

        //******** GO to next Page ********************
        Toast.makeText(getApplicationContext(), name+location, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(AddActivity.this,ShowAddActivity.class);
        startActivity(intent);

    }



}
