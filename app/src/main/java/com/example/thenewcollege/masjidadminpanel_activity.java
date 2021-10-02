package com.example.thenewcollege;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Objects;

public class masjidadminpanel_activity extends AppCompatActivity {


    EditText etdate1picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_masjidadminpanel);


        etdate1picker = findViewById(R.id.etdate1);

        Calendar calender = Calendar.getInstance();
        final int year =calender.get(Calendar.YEAR);
        final int month =calender.get(Calendar.MONTH);
        final int day =calender.get(Calendar.DAY_OF_MONTH);



        
        etdate1picker.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    masjidadminpanel_activity.this, (datePicker, year12, month12, day1) -> {
                        month12 = month12 +1;
                        String date = day1 +"/"+ month12 +"/"+ year12;
                        etdate1picker.setText(date);

                    },year,month,day);
            datePickerDialog.show();

        });
        }

    }
