package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sh = getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
        String username = sh.getString("username", "").toString();
        Toast.makeText(getApplicationContext(),"Welcome" +" "+ username, Toast.LENGTH_SHORT).show();

        CardView card = findViewById(R.id.cardExit);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sh.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });
        CardView findDoctorCard = findViewById(R.id.cardFindDoctor);
        findDoctorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));

            }
        });

        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"lab test clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });
    }
}