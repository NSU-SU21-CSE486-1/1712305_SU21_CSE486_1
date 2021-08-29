package com.example.android.hellosharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private int mColor;
    private int SETTINGS = 0;
    private TextView mShowCountTextView;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.hellosharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this,
                R.color.default_background);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        mCount = mPreferences.getInt(Constants.COUNT_KEY, 0);
        mShowCountTextView.setText(String.format("%s", mCount));

        mColor = mPreferences.getInt(Constants.COLOR_KEY, mColor);
        mShowCountTextView.setBackgroundColor(mColor);
    }


    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    public void countUp(View view) {
        mCount++;
        mShowCountTextView.setText(String.format("%s", mCount));
    }

    public void reset(View view) {
        mCount = 0;
        mShowCountTextView.setText(String.format("%s", mCount));
        mColor = ContextCompat.getColor(this,
                R.color.default_background);
        mShowCountTextView.setBackgroundColor(mColor);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, SETTINGS);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SETTINGS) {
            if (resultCode == RESULT_OK) {
                SharedPreferences.Editor preferenceEditor = mPreferences.edit();
                switch (data.getStringExtra(Constants.COLOR_KEY)) {
                    case "Default":
                        preferenceEditor.putInt(Constants.COLOR_KEY, getResources().getColor(R.color.default_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.default_background));
                        break;
                    case "Red":
                        preferenceEditor.putInt(Constants.COLOR_KEY, getResources().getColor(R.color.red_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.red_background));
                        break;
                    case "Blue":
                        preferenceEditor.putInt(Constants.COLOR_KEY, getResources().getColor(R.color.blue_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.blue_background));
                        break;
                    case "Green":
                        preferenceEditor.putInt(Constants.COLOR_KEY, getResources().getColor(R.color.green_background));
                        mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.green_background));
                        break;
                    default:
                        break;
                }

                if (data.getBooleanExtra(Constants.CORRECT_COUNT, false)) {
                    mCount = data.getIntExtra(Constants.COUNT_KEY, 0);
                    preferenceEditor.putInt(Constants.COUNT_KEY, mCount);
                    mShowCountTextView.setText(String.format("%s", mCount));
                }
                preferenceEditor.apply();
            } else if (resultCode == Constants.RESULT_RESET) {
                SharedPreferences.Editor preferenceEditor = mPreferences.edit();
                mCount = 0;
                mShowCountTextView.setBackgroundColor(getResources().getColor(R.color.default_background));
                preferenceEditor.putInt(Constants.COLOR_KEY, getResources().getColor(R.color.default_background));
                preferenceEditor.putInt(Constants.COUNT_KEY, mCount);
                preferenceEditor.apply();
            }
        }
    }
}
