package com.example.sqlitecrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText etId, etName, etCity;
    Button btnInsert, btnView, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etCity = findViewById(R.id.etCity);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDb.insertData(
                        etName.getText().toString(),
                        etCity.getText().toString()
                );

                Toast.makeText(MainActivity.this,
                        inserted ? "Data Inserted" : "Insert Failed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();

                if (res.getCount() == 0) {
                    showMessage("Error", "No Data Found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("ID: ").append(res.getString(0)).append("\n");
                    buffer.append("Name: ").append(res.getString(1)).append("\n");
                    buffer.append("City: ").append(res.getString(2)).append("\n\n");
                }

                showMessage("Student Data", buffer.toString());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updated = myDb.updateData(
                        etId.getText().toString(),
                        etName.getText().toString(),
                        etCity.getText().toString()
                );

                Toast.makeText(MainActivity.this,
                        updated ? "Data Updated" : "Update Failed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleted = myDb.deleteData(etId.getText().toString());

                Toast.makeText(MainActivity.this,
                        deleted > 0 ? "Data Deleted" : "Delete Failed",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}