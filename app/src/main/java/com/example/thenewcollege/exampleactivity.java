package com.example.thenewcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class exampleactivity extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
      private FirebaseAuth mauth;
      private FloatingActionButton signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exampleactivity);
        mauth=FirebaseAuth.getInstance();
         signout=(FloatingActionButton) findViewById(R.id.signoutbtn);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(exampleactivity.this,Studentauthactivity.class);
                startActivity(intent);

            }
        });
        user=FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userID=user.getUid();
    }
}