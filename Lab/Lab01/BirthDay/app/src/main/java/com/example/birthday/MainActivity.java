package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            int i = 1/0;
        } catch (Exception e) {
            Log.e("log", "Happy birthday HM Tamim");
        }
    }
}