package com.example.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.lang.UProperty;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText email;
    private Button resetp;
    private ProgressBar bar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email=(EditText)findViewById(R.id.etfpemail);
        resetp=(Button) findViewById(R.id.btnresetp);
        bar=(ProgressBar) findViewById(R.id.progressBar3);
        auth=FirebaseAuth.getInstance();

        resetp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpassword();
            }
        });

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    private void resetpassword() {

        String em=email.getText().toString().trim();

        if (em.isEmpty()){
            email.setError("Email is Required");
            email.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            email.setError("Please provide valid Email");
            email.requestFocus();
            return;

        }
        bar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this, "Check Your Email to Reset your Password", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.GONE);
                }else{
                    Toast.makeText(ForgotPasswordActivity.this, "Something went wrong,Try again", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.GONE);
                }
            }
        });
    }
}