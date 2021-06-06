package ru.startandroid.p0081viewbyld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView myTextView = (TextView) findViewById(R.id.myText);
        myTextView.setText("Android is easy");

        Button myButton = (Button) findViewById(R.id.myButton);
        myButton.setText("My first button");
        myButton.setEnabled(false);

        CheckBox myCheckBox = (CheckBox) findViewById(R.id.myCheckBox);
        myCheckBox.setChecked(true);
    }
}