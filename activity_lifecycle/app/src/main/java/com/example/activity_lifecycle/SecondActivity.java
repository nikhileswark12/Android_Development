package com.example.activity_lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityLifecycle";

    private TextView logTextViewSecond;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        logTextViewSecond = findViewById(R.id.logTextViewSecond);
        btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        logTextViewSecond.append(methodName + "\n");
    }
}
