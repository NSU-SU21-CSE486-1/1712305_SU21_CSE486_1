package com.hmtamim.codingchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView title, message;
    Button btn1, btn2, btn3;
    EditText text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        message = findViewById(R.id.message);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);

        btn1.setOnClickListener(view -> {
            startActivity("Message Received(Text 1)", text1.getText().toString(), 100);
        });

        btn2.setOnClickListener(view -> {
            startActivity("Message Received(Text 2)", text2.getText().toString(), 101);
        });

        btn3.setOnClickListener(view -> {
            startActivity("Message Received(Text 3)", text3.getText().toString(), 102);
        });
    }

    private void startActivity(String title, String message, int code) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);
        startActivityForResult(intent, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && data.hasExtra("reply") && resultCode == RESULT_OK) {
            title.setVisibility(View.VISIBLE);
            message.setVisibility(View.VISIBLE);
            if (resultCode == 100)
                title.setText("Reply Received(For Text1)");
            if (resultCode == 101)
                title.setText("Reply Received(For Text2)");
            if (resultCode == 102)
                title.setText("Reply Received(For Text3)");

            message.setText(data.getStringExtra("reply"));
        } else {
            title.setVisibility(View.GONE);
            message.setVisibility(View.GONE);
        }

    }
}