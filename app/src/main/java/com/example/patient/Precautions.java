package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Precautions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_precautions);
    }
}