package com.example.patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NearbyHospitals extends AppCompatActivity {

    RecyclerView recyclerView;
    Button openWithMaps;
    AdapterItem adapter;

    ArrayList<Modal> list;

    /*FusedLocationProviderClient fusedLocationProviderClient;*/

    //instance of firebase database
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("Details");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_nearby_hospitals);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new AdapterItem(this, list);

        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Modal modal = dataSnapshot.getValue(Modal.class);
                    list.add(modal);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*
        fusedLocationProviderClient=LOCATION_SERVICE.getFusedLocationProviderCLient(this);*/


        //maps button
        openWithMaps = findViewById(R.id.openWithMaps);
        openWithMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ActivityCompat.checkSelfPermission(NearbyHospitals.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:0,0?z=21&q=hospitals"));
                    Intent chooser = Intent.createChooser(intent, "Launch Maps");
                    if (chooser.resolveActivity(getPackageManager()) != null) {
                        startActivity(chooser);
                    } else {
                        Toast.makeText(getApplicationContext(), "No Application Found", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    //when permission denied
                    ActivityCompat.requestPermissions(NearbyHospitals.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
                }

            }
        });
    }
}