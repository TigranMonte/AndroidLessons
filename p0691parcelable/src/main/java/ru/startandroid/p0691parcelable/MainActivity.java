package ru.startandroid.p0691parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        MyObject myObject = new MyObject("text", 1);
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myObject);
        Log.d(LOG_TAG, "startActivity");
        startActivity(intent);
    }
}