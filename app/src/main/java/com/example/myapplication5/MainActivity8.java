package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity8 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    private final String TAG = "MainActivity8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        Log.e(TAG, "onCreate: " +sharedPreferences.getString(Name, "Not found"));
        Log.e(TAG, "onCreate: " +sharedPreferences.getString(Phone, "Not found"));
        Log.e(TAG, "onCreate: " +sharedPreferences.getString(Email, "Not found"));

        try {
            FileOutputStream fOut = openFileOutput("temp.txt", MODE_PRIVATE);
            String str = "test data";
            fOut.write(str.getBytes());
            fOut.close();

            FileInputStream fileInputStream = openFileInput("temp.txt");
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            char[] inputBuffer = new char[1024];
            String s = "";
            int charRead;

            while ((charRead = reader.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
            }
            reader.close();
            Log.e(TAG, "onCreate: " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}