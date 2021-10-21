package com.example.thenewcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class OfficeAdminPanel extends AppCompatActivity {
    private TextView dayorder;
    Spinner orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_admin_panel);
        dayorder=(TextView) findViewById(R.id.tvdayorder);
        orders=(Spinner) findViewById(R.id.spnrdayorder);
        String spindata= orders.getSelectedItem().toString();

    }
}