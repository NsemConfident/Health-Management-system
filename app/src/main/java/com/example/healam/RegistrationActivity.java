package com.example.healam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText edUsename, edEmail, edContact, edPassword, edConfirmPassword;
    TextView login;
    Button SignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edUsename = findViewById(R.id.editTextSignupUsername);
        edEmail = findViewById(R.id.editTextTextEmailAddress);
        edContact = findViewById(R.id.editTextPhoneNumber);
        edPassword = findViewById(R.id.editTextSignupPassword);
        edConfirmPassword = findViewById(R.id.editTextTextConfirmPassword);
        login = findViewById(R.id.textViewLogin);
        SignupBtn = findViewById(R.id.buttonSignup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

        SignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsename.getText().toString();
                String email = edEmail.getText().toString();
                String contact = edContact.getText().toString();
                String password = edPassword.getText().toString();
                String passwordconfirm = edConfirmPassword.getText().toString();

                Database db = new Database(getApplicationContext(), "Healthcare", null, 1);


                if ((username.length()==0||email.length()==0||contact.length()==0||password.length()==0||passwordconfirm.length()==0)){
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                }else {
                    if(passwordconfirm.compareTo(passwordconfirm)==0){
                        if (isValid(password)){
                            db.register(username, email, contact, password);
                            Toast.makeText(getApplicationContext(), "Signup sucessfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "password must contain atleast 8 characters including  a letter, a digit and a sysmbol", Toast.LENGTH_SHORT).show();
                        }
                    } else if (contact.length()<8) {
                        Toast.makeText(getApplicationContext(),"enter a valid phone numbe", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "password and confirm password not thesame", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int o = 0; o < passwordhere.length(); o++) {
                char c = passwordhere.charAt(o);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }

        if (f1 == 1 && f2 == 1 && f3 == 1) {
            return true;
        }else {
            return false;
            }
        }
    }
}