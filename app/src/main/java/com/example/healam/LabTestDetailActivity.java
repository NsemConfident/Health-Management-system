package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnBack, btnAddToCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextsLDTextMultiLine);
        btnBack = findViewById(R.id.buttonLTDBack);
        btnAddToCard = findViewById(R.id.buttonLTAddToCard);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailActivity.this, LabTestActivity.class));
            }
        });

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        TextView tv1, tv2, tv3;
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total cost: "+intent.getStringExtra("text3")+"$");

        btnAddToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if (db.checkCard(username, product)==1){
                    Toast.makeText(getApplicationContext(),"product already added", Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username,product,price,"Lab");
                    Toast.makeText(getApplicationContext(),"product added to cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}