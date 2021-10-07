package com.example.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public  class Studentauthactivity extends AppCompatActivity  {
    private FirebaseAuth mAuth;
    private Button login;
    private TextView register;
    private EditText loginemail;
    private EditText password;
    private ProgressBar progressBar;
    private EditText a;
    private EditText b;
    private int attempts=6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_studentauthactivity);
        register = (TextView) findViewById(R.id.tvnewregister);
        login = (Button) findViewById(R.id.btnstudentlogin);
        loginemail = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        TextView info = findViewById(R.id.tvslinfo);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Intent intent =new Intent(Studentauthactivity.this,StudentRegistration.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
               userlogin();
            }
        });

    }

    private void userlogin() {

       String x= loginemail.getText().toString().trim();
       String y= password.getText().toString().trim();
        if(x.isEmpty()) {
            loginemail.setError("Email is Required");
            loginemail.requestFocus();
            return;
        }if(y.isEmpty()){
            password.setError("Password is Required");
            password.requestFocus();
            return;

        }if(!Patterns.EMAIL_ADDRESS.matcher(x).matches()){

            loginemail.setError("Please Enter a Valid Email Address");
            loginemail.requestFocus();
            return;
        }
        if(password.length()<6){
            password.setError("Password should be minimum of 6 caharacters");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(x,y).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()){
                        Intent intent = new Intent(Studentauthactivity.this, exampleactivity.class);
                        startActivity(intent);
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(Studentauthactivity.this, "Please Check your Email to continue", Toast.LENGTH_SHORT).show();
                    }

            }else{
                    Toast.makeText(Studentauthactivity.this, "Failed to Login Please check your Details given", Toast.LENGTH_SHORT).show();

                }
        }


        });
    }

    private void updateUI(FirebaseUser currentUser) {
        Intent intent=new Intent(Studentauthactivity.this,exampleactivity.class);
        startActivity(intent);
    }

}