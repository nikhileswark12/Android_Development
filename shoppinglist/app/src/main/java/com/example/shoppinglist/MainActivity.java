package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkMilk, chkBread, chkVegetables, chkRice, chkOil;
    TextView txtSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkMilk = findViewById(R.id.chkMilk);
        chkBread = findViewById(R.id.chkBread);
        chkVegetables = findViewById(R.id.chkVegetables);
        chkRice = findViewById(R.id.chkRice);
        chkOil = findViewById(R.id.chkOil);
        txtSelected = findViewById(R.id.txtSelected);

        CompoundButton.OnCheckedChangeListener listener =
                (buttonView, isChecked) -> updateSelectedItems();

        chkMilk.setOnCheckedChangeListener(listener);
        chkBread.setOnCheckedChangeListener(listener);
        chkVegetables.setOnCheckedChangeListener(listener);
        chkRice.setOnCheckedChangeListener(listener);
        chkOil.setOnCheckedChangeListener(listener);
    }

    private void updateSelectedItems() {

        StringBuilder selected = new StringBuilder("Selected Items:\n");

        if (chkMilk.isChecked()) selected.append("• Milk\n");
        if (chkBread.isChecked()) selected.append("• Bread\n");
        if (chkVegetables.isChecked()) selected.append("• Vegetables\n");
        if (chkRice.isChecked()) selected.append("• Rice\n");
        if (chkOil.isChecked()) selected.append("• Oil\n");

        if (selected.toString().equals("Selected Items:\n"))
            txtSelected.setText("No items selected");
        else
            txtSelected.setText(selected.toString());
    }
}