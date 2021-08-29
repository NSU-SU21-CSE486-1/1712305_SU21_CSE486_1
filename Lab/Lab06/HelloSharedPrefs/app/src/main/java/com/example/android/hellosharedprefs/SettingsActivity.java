package com.example.android.hellosharedprefs;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinner;
    private String color;
    private ArrayList<String> options = new ArrayList<>();
    private EditText countEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        options.add("Default");
        options.add("Red");
        options.add("Blue");
        options.add("Green");
        countEntry = findViewById(R.id.editText);
        mSpinner = findViewById(R.id.spinner_color);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.color_options, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);
    }


    public void save(View view) {
        Intent intent = new Intent();
        intent.putExtra(Constants.COLOR_KEY, color);

        String countString = countEntry.getText().toString();
        if (!countString.isEmpty()) {
            intent.putExtra(Constants.COUNT_KEY, Integer.parseInt(countString));
            intent.putExtra(Constants.CORRECT_COUNT, true);
        } else
            intent.putExtra(Constants.CORRECT_COUNT, false);

        setResult(RESULT_OK, intent);
        finish();
    }

    public void resetSettings(View view) {
        setResult(Constants.RESULT_RESET, new Intent());
        finish();
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED, new Intent());
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        color = options.get(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        color = "default";
    }

}
