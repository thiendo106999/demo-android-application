package com.example.myapplication5;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    String[] country = {"India", "USA", "China", "Japan", "Other"};
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showToast = findViewById(R.id.show_toast);
        showToast.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Show Toast", Toast.LENGTH_LONG).show());

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> Toast.makeText(getApplicationContext(), toggleButton.getText(), Toast.LENGTH_SHORT).show());

        CheckBox checkBox = findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        Button showDialog = findViewById(R.id.show_dialog);
        showDialog.setOnClickListener(v -> {
            builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to close this application ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        finish();
                        Toast.makeText(getApplicationContext(), "you choose yes action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "you choose no action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.setTitle("Title");
            alertDialog.show();
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, country);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), country[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, country);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter1);


        Button changeActivity = findViewById(R.id.change_activity_2);
        changeActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("name", "Value from activity 1");
            startActivity(intent);
        });

        Button gotoActivity3 = findViewById(R.id.change_activity_3);
        gotoActivity3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        });

        Button gotoActivity4 = findViewById(R.id.change_activity_4);
        gotoActivity4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity4.class);
            startActivity(intent);
        });

        Button button5 = findViewById(R.id.change_activity_5);
        button5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity5.class);
            startActivity(intent);
        });

        Button button6 = findViewById(R.id.change_activity_6);
        button6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity6.class);
            startActivity(intent);
        });

        Button button7 = findViewById(R.id.change_activity_7);
        button7.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity7.class);
            startActivity(intent);
        });

        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, "Thien Thien");
        editor.putString(Phone, "0101010101010");
        editor.putString(Email, "thien@gmail.com");
        editor.apply();
        Button button8 = findViewById(R.id.change_activity_8);
        button8.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity8.class);
            startActivity(intent);
        });
    }
}