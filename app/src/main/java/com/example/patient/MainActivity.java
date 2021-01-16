package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnCovid, BtnConsultation, BtnEmergency, BtnPrecautions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_main);

        initalizeViews();

        //Covid Page
        BtnCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CovidRelated.class);

                startActivity(intent);
            }
        });

        //Consultation Page
        BtnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OnlineConsulting.class);

                startActivity(intent);
            }
        });

        //Emergency Page
        BtnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmergencyContacts.class);

                startActivity(intent);
            }
        });

        //Precautions Page
        BtnPrecautions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Precautions.class);
                startActivity(intent);
            }
        });
    }

    void initalizeViews() {

        BtnCovid = findViewById(R.id.BtnCovid);
        BtnEmergency = findViewById(R.id.BtnEmergency);
        BtnConsultation = findViewById(R.id.BtnConsultation);
        BtnPrecautions=findViewById(R.id.BtnPrecautions);
    }
}