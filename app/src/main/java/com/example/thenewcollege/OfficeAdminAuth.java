package com.example.thenewcollege;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class OfficeAdminAuth extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    private  int attempts=6;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_office_admin_auth);
        login=(Button)findViewById(R.id.btnOFFICElogin);
        name=(EditText)findViewById(R.id.etOFFICEusername);
        password=(EditText)findViewById(R.id.etOFFICEpassword);
        info=(TextView) findViewById(R.id.tvOFFICEinfo);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authentication1(name.getText().toString().trim(),password.getText().toString().trim());

            }
        });
    }
    private void authentication1(String username,String password){
        if((username.equals("Admin"))&&(password.equals("1234"))){
            Intent intent =new Intent(OfficeAdminAuth.this,OfficeAdminPanel.class);
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