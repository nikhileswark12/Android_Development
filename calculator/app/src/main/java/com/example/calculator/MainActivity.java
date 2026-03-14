package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDisplay;
    private String first = "";
    private String second = "";
    private String operator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display
        tvDisplay = findViewById(R.id.tvDisplay);

        // All clickable button IDs
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                R.id.btn8, R.id.btn9, R.id.btnDecimal,
                R.id.btnAdd, R.id.btnSubtract,
                R.id.btnMultiply, R.id.btnDivide,
                R.id.btnEquals, R.id.btnClear
        };

        // Attach click listener SAFELY
        for (int id : buttonIds) {
            View view = findViewById(id);
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        String text = "";

        // ✅ SAFE: check before casting
        if (v instanceof Button) {
            text = ((Button) v).getText().toString();
        }

        if (id == R.id.btnClear) {
            clear();

        } else if (id == R.id.btnAdd || id == R.id.btnSubtract ||
                id == R.id.btnMultiply || id == R.id.btnDivide) {
            setOperator(text);

        } else if (id == R.id.btnEquals) {
            calculate();

        } else if (id == R.id.btnDecimal) {
            addDecimal();

        } else {
            addDigit(text);
        }
    }

    private void addDigit(String digit) {
        if (!isOperatorPressed) {
            first += digit;
            tvDisplay.setText(first);
        } else {
            second += digit;
            tvDisplay.setText(second);
        }
    }

    private void addDecimal() {
        if (!isOperatorPressed && !first.contains(".")) {
            first = first.isEmpty() ? "0." : first + ".";
            tvDisplay.setText(first);

        } else if (isOperatorPressed && !second.contains(".")) {
            second = second.isEmpty() ? "0." : second + ".";
            tvDisplay.setText(second);
        }
    }

    private void setOperator(String op) {
        if (!first.isEmpty()) {
            operator = op;
            isOperatorPressed = true;
        }
    }

    private void calculate() {
        if (first.isEmpty() || second.isEmpty()) return;

        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);
        double result = 0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = a / b;
                break;
        }

        String output = (result == (long) result)
                ? String.valueOf((long) result)
                : String.valueOf(result);

        tvDisplay.setText(output);

        // Reset state
        first = output;
        second = "";
        operator = "";
        isOperatorPressed = false;
    }

    private void clear() {
        first = "";
        second = "";
        operator = "";
        isOperatorPressed = false;
        tvDisplay.setText("0");
    }
}
