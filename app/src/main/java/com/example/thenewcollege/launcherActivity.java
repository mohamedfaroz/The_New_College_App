package com.example.thenewcollege;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class launcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
getSupportActionBar().hide();

        setContentView(R.layout.activity_launcher);

        Button madmin=findViewById(R.id.btnmadmin);
        madmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(launcherActivity.this,authentication_activity.class);
                startActivity(intent);

            }
        });



    }
}