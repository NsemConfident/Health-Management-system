package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardExit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        CardView familyPhysician = findViewById(R.id.cardFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "family physician");
                startActivity(it);
            }
        });

        CardView Dietician = findViewById(R.id.cardDietician);
        Dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });
        CardView Dentist = findViewById(R.id.cardFDentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });

        CardView Surgeon = findViewById(R.id.cardFDSurgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });

        CardView Cardeologist = findViewById(R.id.cardFDCardeologist);
        Cardeologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                it.putExtra("title", "Cardeologist");
                startActivity(it);
            }
        });
    }
}