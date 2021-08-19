package com.hmtsoft.lab4;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDate, btnTime;
    TextView textDate, textTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        textDate = findViewById(R.id.dateText);
        textTime = findViewById(R.id.timeText);

        btnTime.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                    (view, hourOfDay, minute) -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0, 0, 0, hourOfDay, minute);
                        textTime.setText("Chosen Time :" + DateFormat.format("hh:mm aa", calendar));
                    }, 12, 0, false
            );
            timePickerDialog.show();
        });

        btnDate.setOnClickListener(v -> {
            MaterialDatePicker.Builder date = MaterialDatePicker.Builder.datePicker();
            date.setTitleText("Select date");
            MaterialDatePicker materialDatePicker = date.build();
            materialDatePicker.addOnPositiveButtonClickListener(selection -> textDate.setText("Selected Date : " + materialDatePicker.getHeaderText()));
            materialDatePicker.show(getSupportFragmentManager(), "date_picker");
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_exit:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}