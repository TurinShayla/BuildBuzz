package com.example.buildbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class PushSingleShowActivity extends AppCompatActivity implements View.OnClickListener{
    public ImageButton btn_add, btn_home, btn_save, btn_map, btn_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_single_show);

        callButton();
    }
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
                Intent intent2 = new Intent(PushSingleShowActivity.this, MainActivity.class);
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