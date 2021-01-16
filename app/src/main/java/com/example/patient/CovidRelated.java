package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class CovidRelated extends AppCompatActivity {

    CardView cardViewHospital, cardViewTesting, cardViewBeds, cardViewMedicals, cardViewRules, cardViewPlasma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_covid_related);

        inializeViews();

        //Hospital Page
        cardViewHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?z=21&q=hospitals"));
                Intent chooser = Intent.createChooser(intent, "Launch Maps");
                if (chooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                } else {
                    Toast.makeText(getApplicationContext(), "No Application Found", Toast.LENGTH_SHORT).show();
                }*/
                //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CovidRelated.this, HospitalDetails.class);
                startActivity(intent);
            }
        });

        //Testing Page
        cardViewTesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=laboratory"));
                Intent chooser = Intent.createChooser(intent, "Launch Maps");
                if (chooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                } else {
                    Toast.makeText(getApplicationContext(), "No Application Found", Toast.LENGTH_SHORT).show();
                }*/
                //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CovidRelated.this, NearbyHospitals.class);
                startActivity(intent);
            }
        });

        //Beds Page
        cardViewBeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CovidRelated.this, BedsAvailable.class);
                startActivity(intent);
            }
        });

        //Medical Page
        cardViewMedicals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=medical"));
                Intent chooser = Intent.createChooser(intent, "Launch Maps");
                if (chooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                } else {
                    Toast.makeText(getApplicationContext(), "No Application Found", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //Plasma Page
        cardViewPlasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CovidRelated.this, PlasmaAvailable.class);
                startActivity(intent);
            }
        });

        //Rules Page
        cardViewRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CovidRelated.this, Guidelines.class);
                startActivity(intent);

                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view1);
                getLifecycle().addObserver(youTubePlayerView);
            }
        });
    }

    private void inializeViews() {
        cardViewHospital = findViewById(R.id.cardViewHospital);
        cardViewTesting = findViewById(R.id.cardViewTesting);
        cardViewBeds = findViewById(R.id.cardViewBeds);
        cardViewMedicals = findViewById(R.id.cardViewMedicals);
        cardViewRules = findViewById(R.id.cardViewRules);
        cardViewPlasma = findViewById(R.id.cardViewPlasma);
    }
}