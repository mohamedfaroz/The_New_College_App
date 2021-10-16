package com.example.thenewcollege;

import android.app.DatePickerDialog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Objects;

public class masjidadminpanel_activity extends AppCompatActivity {


    EditText etdate1picker;
    TextView etfajrpicker;
    TextView etzuhrpicker;
    TextView etasarpicker;
    TextView etmaghribpicker;
    TextView etishapicker;
    TextView etjummahpicker;
    int t1Hour,t1Minute;
    int t2Hour,t2Minute;
    int t3Hour,t3Minute;
    int t4Hour,t4Minute;
    int t5Hour,t5Minute;
    int t6Hour,t6Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_masjidadminpanel);


        etdate1picker = findViewById(R.id.etdate1);
        etfajrpicker = findViewById(R.id.tvfajrtime);
        etzuhrpicker = findViewById(R.id.tvzuhrtime);
        etasarpicker = findViewById(R.id.tvasartime);
        etmaghribpicker = findViewById(R.id.tvmaghribtime);
        etishapicker = findViewById(R.id.tvishatime);
        etjummahpicker = findViewById(R.id.tvjummahtime);


        Calendar calender = Calendar.getInstance();
        final int year =calender.get(Calendar.YEAR);
        final int month =calender.get(Calendar.MONTH);
        final int day =calender.get(Calendar.DAY_OF_MONTH);


        etfajrpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t1Hour = hourofDay;
                                t1Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t1Hour,t1Minute);
                                etfajrpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t1Hour,t1Minute);

                timePickerDialog.show();

                            }


                ;
            });

        etzuhrpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t2Hour = hourofDay;
                                t2Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t2Hour,t2Minute);
                                etzuhrpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t2Hour,t2Minute);

                timePickerDialog.show();

            }


            ;
        });


        etasarpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t3Hour = hourofDay;
                                t3Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t3Hour,t3Minute);
                                etasarpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t3Hour,t3Minute);

                timePickerDialog.show();

            }


            ;
        });

        etmaghribpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t4Hour = hourofDay;
                                t4Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t4Hour,t4Minute);
                                etmaghribpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t4Hour,t4Minute);

                timePickerDialog.show();
            }


            ;
        });

        etishapicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t3Hour = hourofDay;
                                t3Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t5Hour,t5Minute);
                                etishapicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t5Hour,t5Minute);

                timePickerDialog.show();

            }


            ;
        });

        etjummahpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t3Hour = hourofDay;
                                t3Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t6Hour,t6Minute);
                                etjummahpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t6Hour,t6Minute);

                timePickerDialog.show();

            }


            ;
        });








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
