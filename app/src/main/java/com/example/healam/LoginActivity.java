package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView signup;
        EditText username, password;
        Button loginBtn;

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        signup = findViewById(R.id.textViewSignup);

        loginBtn = findViewById(R.id.buttonLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edUsername = username.getText().toString();
                String edPassword = password.getText().toString();

                if(edUsername.length()==0||edPassword.length()==0){
                    Toast.makeText(getApplicationContext(), "please fill in your details", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "login sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

    }
}