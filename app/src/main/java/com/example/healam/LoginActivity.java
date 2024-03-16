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

                Database db = new Database(getApplicationContext(), "Healthcare", null, 1);


                if(edUsername.length()==0||edPassword.length()==0){
                    Toast.makeText(getApplicationContext(), "please fill in your details", Toast.LENGTH_SHORT).show();
                }else {
                    if(db.login(edUsername, edPassword)==1){
                        Toast.makeText(getApplicationContext(), "login sucessful", Toast.LENGTH_SHORT).show();

                        /* save the username in a small memory so we can display that on the home page.
                        when the user logs in, this we are going to use shared preferences
                         */

                        SharedPreferences sh = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sh.edit();
                        editor.putString("username", edUsername);
                        editor.apply();

                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_SHORT).show();

                    }

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