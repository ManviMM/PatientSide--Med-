package com.example.patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyContacts extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView EditTxtNumber1, EditTxtNumber2, EditTxtNumber3;
    private Button btnCallNow1, btnCallNow2, btnCallNow3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_emergency_contacts);

        initalizeViews();


        btnCallNow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = EditTxtNumber1.getText().toString();
                CallButton(phoneNumber);

            }
        });

        btnCallNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = EditTxtNumber2.getText().toString();
                CallButton(phoneNumber);

            }
        });

        btnCallNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = EditTxtNumber3.getText().toString();
                CallButton(phoneNumber);

            }
        });

    }

    void initalizeViews() {
        EditTxtNumber1 = findViewById(R.id.EditTxtNumber1);
        EditTxtNumber2 = findViewById(R.id.EditTxtNumber2);
        EditTxtNumber3 = findViewById(R.id.EditTxtNumber3);

        btnCallNow1 = findViewById(R.id.btnCallNow1);
        btnCallNow2 = findViewById(R.id.btnCallNow2);
        btnCallNow3 = findViewById(R.id.btnCallNow3);


    }

    private void CallButton(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);

        if (phoneNumber.isEmpty()) {

            Toast.makeText(getApplicationContext(), "No number provided", Toast.LENGTH_SHORT).show();
        } else {
            String s = "tel:" + phoneNumber;
            intent.setData(Uri.parse(s));
        }

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(EmergencyContacts.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
            requestPermission();
        } else {
            startActivity(intent);
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(EmergencyContacts.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

    }
}
/*
    private void CallButton() {

        String number = EditTxtNumber1.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(EmergencyContacts.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(EmergencyContacts.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "Telphone :" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                CallButton();
        } else {
            Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
        }
    }*/