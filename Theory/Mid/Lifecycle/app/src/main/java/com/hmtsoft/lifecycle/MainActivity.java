package com.hmtsoft.lifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.hmtsoft.lifecycle.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity ", "onCreate method called");
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity ", "onStart method called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity ", "onResume method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity ", "onPause method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity ", "onStop method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity ", "onDestroyed method called");
    }
}