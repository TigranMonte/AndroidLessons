package ru.startandroid.p0992notificationsimple2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.tv);

        // initialize notification manager
        NotificationManager manager = (NotificationManager) getApplicationContext()
                .getSystemService(NOTIFICATION_SERVICE);
        // clear notification
        manager.cancelAll();

        // check condition
        if (getIntent().hasExtra("yes")) {
            // when yes button is clicked
            // set text
            tv.setText("You accepted request");
            // set text color
            tv.setTextColor(Color.GREEN);
        } else if (getIntent().hasExtra("no")) {
            // when no button is clicked
            // set text
            tv.setText("You rejected request");
            // set text color
            tv.setTextColor(Color.RED);
        }
    }
}