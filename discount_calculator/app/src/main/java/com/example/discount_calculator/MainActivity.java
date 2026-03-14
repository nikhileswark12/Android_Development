package com.example.discount_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtBill;
    RadioGroup radioGroup;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBill = findViewById(R.id.edtBill);
        radioGroup = findViewById(R.id.radioGroupDiscount);
        txtResult = findViewById(R.id.txtResult);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> calculateDiscount());
    }

    private void calculateDiscount() {

        String billText = edtBill.getText().toString();

        if (billText.isEmpty()) {
            txtResult.setText("Please enter bill amount!");
            return;
        }

        double bill = Double.parseDouble(billText);
        double discountPercent = 0;

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.radio10) {
            discountPercent = 10;
        }
        else if (selectedId == R.id.radio15) {
            discountPercent = 15;
        }
        else if (selectedId == R.id.radio20) {
            discountPercent = 20;
        }

        double discountAmount = (bill * discountPercent) / 100;
        double finalAmount = bill - discountAmount;

        txtResult.setText(
                "Discount: ₹" + discountAmount +
                        "\nFinal Bill: ₹" + finalAmount
        );
    }
}