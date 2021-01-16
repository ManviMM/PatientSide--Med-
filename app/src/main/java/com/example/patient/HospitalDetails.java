package com.example.patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class HospitalDetails extends AppCompatActivity {

    TextInputLayout regname, regaddress, regphone, regwebsite, regemail;
    TextInputLayout regdoctor1, regdoctor2, regdoctor3;
    TextInputLayout regEmergency1, regEmergency2;
    Button btnSaveDetails;

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

        setContentView(R.layout.activity_hospital_details);

        regname = findViewById(R.id.regname);
        regaddress = findViewById(R.id.regaddress);
        regphone = findViewById(R.id.regphone);
        regwebsite = findViewById(R.id.regwebsite);
        regemail = findViewById(R.id.regemail);

        regdoctor1 = findViewById(R.id.regdoctor1);
        regdoctor2 = findViewById(R.id.regdoctor2);
        regdoctor3 = findViewById(R.id.regdoctor3);

        regEmergency1 = findViewById(R.id.regemerg1);
        regEmergency2 = findViewById(R.id.regemerg2);

        btnSaveDetails = findViewById(R.id.btnSaveDetails);
        btnSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = regname.getEditText().getText().toString();
                String address = regaddress.getEditText().getText().toString();
                String phone = regphone.getEditText().getText().toString();
                String website = regwebsite.getEditText().getText().toString();
                String email = regemail.getEditText().getText().toString();

                String doctor1 = regdoctor1.getEditText().getText().toString();
                String doctor2 = regdoctor2.getEditText().getText().toString();
                String doctor3 = regdoctor3.getEditText().getText().toString();

                String emerg1 = regEmergency1.getEditText().getText().toString();
                String emerg2 = regEmergency2.getEditText().getText().toString();

                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("Name",name);
                hashMap.put("Address",address);
                hashMap.put("Phone",phone);
                hashMap.put("Website",website);
                hashMap.put("Email",email);

                hashMap.put("Doc1",doctor1);
                hashMap.put("Doc2",doctor2);
                hashMap.put("Doc3",doctor3);

                hashMap.put("Emergency1",emerg1);
                hashMap.put("Emergency2",emerg2);

                root.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(HospitalDetails.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}