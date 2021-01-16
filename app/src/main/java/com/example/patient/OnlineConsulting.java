package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class OnlineConsulting extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_online_consulting);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyDoctor[] myDoctors = new MyDoctor[]{
                new MyDoctor("Dr. Mukesh Budhwani", "(Physician)", "MD - Physician", "18 Years Experience", R.drawable.d1),
                new MyDoctor("Dr. Pranami Mehta", "(Pediatrician)", "MBBS, Diploma in Child Health (DCH)", "14 Years Experience", R.drawable.d2),
                new MyDoctor("Dr. Ajay Kothadiya", "(ENT Specialist)", "MBBS, Diploma in Otorhinolaryngology (DLO)", "21 Years Experience", R.drawable.d3),
                new MyDoctor("Dr. Sanjay Jain", "(Dentist)", "BDS, MDS - Periodontology and Oral Implantology", "19 Years Experience", R.drawable.d4),
                new MyDoctor("Dr. Sneha A. Deshpande", "(Gynecologist||Obstetrician)", "MBBS, DNB - Obstetrics & Gynecology, DGO", "13 Years Experience", R.drawable.d5),
                new MyDoctor("Dr. Anirudha Deshpande", "(Orthopedist)", "MBBS, DNB - Orthopedics/Orthopedic Surgery", "16 Years Experience", R.drawable.d6),
                new MyDoctor("Dr. Akanksha Barthwal Thakre", "(Dermatologist)", "MBBS, Diploma in Dermatology", "8 Years Experience", R.drawable.d7),
                new MyDoctor("Dr. Shilpa Patil", "(Eye Specialist)", "MBBS, DOMS, DNB - Ophthalmology, FCPS- Ophthalmology", "14 Years Experience", R.drawable.d8),
                new MyDoctor("Dr. Bilkish Raje", "(Dietitian||Nutritionist)", "MSc - Dietitics / Nutrition", "16 Years Experience", R.drawable.d9),
                new MyDoctor("Dr. Deepa Karwa", "(Ayurveda)", "BAMS, Post Graduate Diploma In Yoga", "12 Years Experience", R.drawable.d10),
                new MyDoctor("Dr. Mahima Soni", "(Homoeopath)", "BHMS", "14 Years Experience", R.drawable.d11),
                new MyDoctor("Dr. Revathi Adhalakha", "(Physiotherapist)", "BPTh/BPT", "7 Years Experience", R.drawable.d12)

        };
        adapter = new Adapter(this, myDoctors);
        recyclerView.setAdapter(adapter);

    }
}