package com.example.collegecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView txtTic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupCourse);
        txtTic = findViewById(R.id.txtTic);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            int ticValue = 0;

            if (checkedId == R.id.radioBCA) {
                ticValue = 120;
            }
            else if (checkedId == R.id.radioBBA) {
                ticValue = 110;
            }
            else if (checkedId == R.id.radioMCA) {
                ticValue = 150;
            }
            else if (checkedId == R.id.radioMBA) {
                ticValue = 160;
            }

            txtTic.setText("TIC: " + ticValue);

        });
    }
}