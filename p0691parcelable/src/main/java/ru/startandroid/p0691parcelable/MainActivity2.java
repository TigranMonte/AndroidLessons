package ru.startandroid.p0691parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(LOG_TAG, "getParcelableExtra");
        MyObject myObject = (MyObject) getIntent().getParcelableExtra(MyObject.class.getCanonicalName());
        Log.d(LOG_TAG, "myObject: " + myObject.s + ", " + myObject.i);
    }
}