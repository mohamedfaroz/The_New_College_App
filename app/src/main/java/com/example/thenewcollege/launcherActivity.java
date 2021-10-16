package com.example.thenewcollege;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class launcherActivity extends AppCompatActivity {
      private Button Student;
      private Button oadmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getSupportActionBar().hide();

        setContentView(R.layout.activity_launcher);
        Student=(Button)findViewById(R.id.btnstudent);
        Button madmin=findViewById(R.id.btnmadmin);
        oadmin=(Button)findViewById(R.id.btnoadmin);
        madmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(launcherActivity.this,authentication_activity.class);
                startActivity(intent);

            }
        });
        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(launcherActivity.this,Studentauthactivity.class);
                startActivity(intent1);
            }
        });
        oadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(launcherActivity.this,OfficeAdminAuth.class);
                startActivity(intent);
            }
        });



    }
}