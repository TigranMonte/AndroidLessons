package ru.startandroid.p0941servicekillclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View v) {

        Intent intent = new Intent("ru.startandroid.p0941servicekillclient.MyService");
        intent.setPackage("ru.startandroid.p0941servicekillserver");
        intent.putExtra("name", "value");
        startForegroundService(intent);

    }
}