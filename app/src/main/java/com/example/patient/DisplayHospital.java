package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayHospital extends AppCompatActivity {

    private TextView HosptialName, HosptialAddress, HosptialPhone, HosptialWebsite, HosptialEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_display_hospital);

        Intent i = getIntent();

        String name = i.getStringExtra("Name");
        HosptialName = findViewById(R.id.HosptialName);
        HosptialName.setText(name);

        String address = i.getStringExtra("Address");
        HosptialAddress = findViewById(R.id.HosptialAddress);
        HosptialAddress.setText(address);

        String phone = i.getStringExtra("Phone");
        HosptialPhone = findViewById(R.id.HosptialPhone);
        HosptialPhone.setText(phone);

        String website = i.getStringExtra("Website");
        HosptialWebsite = findViewById(R.id.HosptialWebsite);
        HosptialWebsite.setText(website);

        String email = i.getStringExtra("Email");
        HosptialEmail = findViewById(R.id.HosptialEmail);
        HosptialEmail.setText(email);

    }
}