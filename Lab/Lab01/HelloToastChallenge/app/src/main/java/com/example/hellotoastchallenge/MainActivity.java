package com.example.hellotoastchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Button btnToast;
    private Button btnCount;
    private TextView tvCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);
        btnCount = findViewById(R.id.btnCount);
        tvCount = findViewById(R.id.tvCount);
    }


    public void funcToast(View view){
        Toast.makeText(MainActivity.this, count + "", Toast.LENGTH_SHORT).show();
    }

    public void funcCount(View view){
        count++;
        tvCount.setText(count + "");
    }
}