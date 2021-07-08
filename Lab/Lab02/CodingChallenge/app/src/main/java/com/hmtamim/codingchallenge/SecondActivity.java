package com.hmtamim.codingchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView title, message;
    Button btn1;
    EditText text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Second Activity");

        title = findViewById(R.id.title);
        message = findViewById(R.id.message);
        btn1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);

        title.setText(getIntent().getStringExtra("title"));
        message.setText(getIntent().getStringExtra("message"));

        btn1.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("reply", text1.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}