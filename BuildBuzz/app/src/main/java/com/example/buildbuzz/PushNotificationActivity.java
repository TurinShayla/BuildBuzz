package com.example.buildbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PushNotificationActivity extends AppCompatActivity implements View.OnClickListener{
    private AppCompatButton btn_notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notification);
        btn_notification=findViewById(R.id.btn_notification);
        btn_notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_notification:
              //  Toast.makeText(this, "Home Page", Toast.LENGTH_SHORT).show();
                Toast.makeText(this,"New Notification",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(PushNotificationActivity.this, PushSingleShowActivity.class);
                startActivity(intent2);
                break;
        }
    }
}