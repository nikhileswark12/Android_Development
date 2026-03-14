package com.example.intentdemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tvMessage;
    Button btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvMessage = findViewById(R.id.tvMessage);
        btnGoBack = findViewById(R.id.btnGoBack);

        // Receive data from Intent
        String receivedMessage = getIntent().getStringExtra("msg");
        tvMessage.setText(receivedMessage);

        btnGoBack.setOnClickListener(v -> finish());
    }
}
