package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.option1) {
            tvResult.setText("Selected: Option 1");
            return true;
        } else if (id == R.id.option2) {
            tvResult.setText("Selected: Option 2");
            return true;
        } else if (id == R.id.option3) {
            tvResult.setText("Selected: Option 3");
            return true;
        } else if (id == R.id.option4) {
            tvResult.setText("Selected: Option 4");
            return true;
        } else if (id == R.id.option5) {
            tvResult.setText("Selected: Option 5");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}