package com.example.thenewcollege;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public  class Studentauthactivity extends AppCompatActivity  {
    private FirebaseAuth mAuth;
    private Button createacc;
    private TextView register;
    private EditText loginemail;
    private EditText password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_studentauthactivity);
        register = (TextView) findViewById(R.id.tvnewregister);
        createacc = (Button) findViewById(R.id.btnstudentlogin);
        loginemail = (TextInputEditText) findViewById(R.id.etemail);
        password = (TextInputEditText) findViewById(R.id.etpassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);
        loginemail.getText().toString();
        password.getText().toString();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Studentauthactivity.this,StudentRegistration.class);
                startActivity(intent);
            }
        });


    }

}