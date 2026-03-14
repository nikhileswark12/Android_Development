package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNewUser, edtNewPass;
    Button btnSubmit;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNewUser = findViewById(R.id.edtNewUser);
        edtNewPass = findViewById(R.id.edtNewPass);
        btnSubmit = findViewById(R.id.btnSubmit);

        sharedPref = getSharedPreferences("UserData", MODE_PRIVATE);

        btnSubmit.setOnClickListener(v -> {

            String newUser = edtNewUser.getText().toString();
            String newPass = edtNewPass.getText().toString();

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", newUser);
            editor.putString("password", newPass);
            editor.apply();

            Toast.makeText(this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();

            finish();

        });

    }
}