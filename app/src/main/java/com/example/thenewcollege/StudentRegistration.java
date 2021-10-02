package com.example.thenewcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class StudentRegistration extends AppCompatActivity implements View.OnClickListener{
    private EditText studentname;
    private EditText department;
    private EditText registermail;
    private EditText registerpassword;
    private Button registeruser;
    private ProgressBar bar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        studentname = (EditText) findViewById(R.id.etnewname);
        department = (EditText) findViewById(R.id.etdepartment);
        registermail = (EditText) findViewById(R.id.etnewmail);
        registerpassword = (EditText) findViewById(R.id.etnewpass);
        registeruser = (Button) findViewById(R.id.btnregisteruser);
        bar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
        registeruser.setOnClickListener((OnClickListener) this);



    }


    private void registerUser() {

        String n = studentname.getText().toString().trim();
        String d = department.getText().toString().trim();
        String em = registermail.getText().toString().trim();
        String pas = registerpassword.getText().toString().trim();

        if (n.isEmpty()) {
            studentname.setError("Full Name is Required");
            studentname.requestFocus();
            return;
        }
        if (d.isEmpty()) {
            department.setError("Department is Required");
            department.requestFocus();
            return;

        }
        if (em.isEmpty()) {
            registermail.setError("Email is Required");
            registermail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
            registermail.setError("Enter valid Email provided by College");
            registermail.requestFocus();
            return;

        }
        if (pas.isEmpty()) {
            registerpassword.setError("Password is required");
            registerpassword.requestFocus();
            return;
        }
        if (pas.length() < 6) {
            registerpassword.setError("Password should be minimum of 6 caharacters");
            registerpassword.requestFocus();
            return;
        }

    }


    @Override
    public void onClick(View view) {
        registerUser();
        Intent intent = new Intent(StudentRegistration.this, exampleactivity.class);
        startActivity(intent);
    }
}