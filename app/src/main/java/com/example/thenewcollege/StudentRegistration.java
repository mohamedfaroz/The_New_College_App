package com.example.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegistration extends AppCompatActivity implements View.OnClickListener{
    private EditText studentname;
    private EditText department;
    public EditText registermail;
    public EditText registerpassword;
    private Button registeruser;
    private ProgressBar bar;
    private FirebaseAuth mAuth;
    private static final String TAG ="Hello";

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
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
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
        bar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(em,pas)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(n,em,d);
                            FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(StudentRegistration.this, "User has been Registered Succecssfully", Toast.LENGTH_LONG).show();
                                        bar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(StudentRegistration.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                        } else {
                            Toast.makeText(StudentRegistration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            bar.setVisibility(View.GONE);
                        }
                    }
                });
    }
        public void onClick(View view) {

                        registerUser();
                    }

}