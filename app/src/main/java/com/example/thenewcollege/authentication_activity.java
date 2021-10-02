package com.example.thenewcollege;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class authentication_activity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    private  int attempts=6;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_authentication);
        login=(Button)findViewById(R.id.btnlogin);
        name=(EditText)findViewById(R.id.etusername);
        password=(EditText)findViewById(R.id.etpassword);
        info=(TextView) findViewById(R.id.tvinfo);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authentication2(name.getText().toString(),password.getText().toString());

            }
        });
    }
    private void authentication2(String username,String password){
        if((username.equals("Admin"))&&(password.equals("1234"))){
            Intent intent =new Intent(authentication_activity.this,masjidadminpanel_activity.class);
            startActivity(intent);
        }else{
            attempts--;
            info.setText("Attempts left :  "+ String.valueOf(attempts));
        }
        if (attempts==0){
            login.setEnabled(false);
        }

    }
}