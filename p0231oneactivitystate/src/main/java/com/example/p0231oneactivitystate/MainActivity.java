package com.example.p0231oneactivitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity is visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity gets focus (Resumed state)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity paused (Paused state)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity stopped (Stopped state");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity destroyed");
    }
}