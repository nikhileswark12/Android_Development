package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        sharedPref = getSharedPreferences("UserData", MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {

            String user = edtUsername.getText().toString();
            String pass = edtPassword.getText().toString();

            String regUser = sharedPref.getString("username", "");
            String regPass = sharedPref.getString("password", "");

            if (user.equals(regUser) && pass.equals(regPass)) {
                Toast.makeText(this, "Welcome " + user, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }

        });

        btnRegister.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(i);
        });

    }
}