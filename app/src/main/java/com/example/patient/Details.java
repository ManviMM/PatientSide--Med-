package com.example.patient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Details extends AppCompatActivity {
    private TextView txtNameDoc, txtProfessionDoc, txtStudyDoc, txtExperienceDoc, txtInquiryNumber;
    private ImageView imgDoc;
    private Button btnProceed, btnInquiry;
    public String upiName;

    TextView confirmDate,confirmTime;
    int hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_details);

        confirmDate=findViewById(R.id.confirmDate);
        confirmTime=findViewById(R.id.confirmTime);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //calender logic
        Calendar calender= Calendar.getInstance();
        final int year=calender.get(Calendar.YEAR);
        final int month=calender.get(Calendar.MONTH);
        final int day=calender.get(Calendar.DAY_OF_MONTH);

        confirmDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize the date picker dialog
                DatePickerDialog datePickerDialog =new DatePickerDialog(Details.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        //store the date in string
                        String date=day+"/"+month+"/"+year;
                        //set the date in text view
                        confirmDate.setText(date);

                    }
                },year,month,day);
                //to disable past date feature
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                //show the dialog
                datePickerDialog.show();
            }
        });


        //time logic
        confirmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initialize the time picker dialog
                TimePickerDialog timePickerDialog=new TimePickerDialog(Details.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfDay) {
                       //initialize hour and minute
                        hour=hourOfDay;
                        minute=minuteOfDay;

                        //initialize calender
                        Calendar calendar=Calendar.getInstance();

                        //Set hour and minute
                        calendar.set(0,0,0,hour,minute);

                        //set selected time on text view
                        confirmTime.setText(DateFormat.format("hh:mm aa",calendar));
                    }
                }, 12,0,false);
                //display the previous selected time
                timePickerDialog.updateTime(hour,minute);
                //show the dialog
                timePickerDialog.show();
            }
        });



        Intent i = getIntent();
        String name = i.getStringExtra("name");
        txtNameDoc = findViewById(R.id.txtDoctorName);
        txtNameDoc.setText(name);
        upiName = txtNameDoc.getText().toString();



        String profession = i.getStringExtra("prof");
        txtProfessionDoc = findViewById(R.id.txtDoctorProfession);
        txtProfessionDoc.setText(profession);

        String study = i.getStringExtra("study");
        txtStudyDoc = findViewById(R.id.txtDoctorStudy);
        txtStudyDoc.setText(study);

        String experience = i.getStringExtra("exp");
        txtExperienceDoc = findViewById(R.id.txtDoctorExperience);
        txtExperienceDoc.setText(experience);

        Integer img = i.getIntExtra("image", 0);
        imgDoc = findViewById(R.id.imgDoctor);
        imgDoc.setImageResource(img);

        //for Inquiry
        txtInquiryNumber = findViewById(R.id.txtInquiryNumber);
        btnInquiry = findViewById(R.id.btnInquiry);
        btnInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtInquiryNumber.getText().toString();
                inquiry(phoneNumber);
            }
        });


        //for UPI
        btnProceed = findViewById(R.id.btnProceed);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, UpiPaymentGateway.class);
                intent.putExtra("name",upiName); //sending names to the upiPayment class
                startActivity(intent);
            }
        });
    }

    private void inquiry(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);

        if (phoneNumber.isEmpty()) {

            Toast.makeText(getApplicationContext(), "No number provided", Toast.LENGTH_SHORT).show();
        } else {
            String s = "tel:" + phoneNumber;
            intent.setData(Uri.parse(s));
        }

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(Details.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
            requestPermission();
        } else {
            startActivity(intent);
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(Details.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

    }
}