package com.example.activity_lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLifecycle";

    private TextView logTextView;
    private ScrollView scrollView;
    private Button btnOpenSecond, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logTextView = findViewById(R.id.logTextView);
        scrollView = findViewById(R.id.scrollView);
        btnOpenSecond = findViewById(R.id.btnOpenSecond);
        btnClear = findViewById(R.id.btnClear);

        btnOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logTextView.setText("");
            }
        });

        logAndShow("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndShow("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndShow("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndShow("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndShow("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndShow("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndShow("onDestroy");
    }

    private void logAndShow(String methodName) {
        Log.d(TAG, methodName);
        Toast.makeText(this, methodName, Toast.LENGTH_SHORT).show();
        logTextView.append(methodName + "\n");

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
