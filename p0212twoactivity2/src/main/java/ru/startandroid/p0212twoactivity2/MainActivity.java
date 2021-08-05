package ru.startandroid.p0212twoactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {

        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        // для вызова второго активити данного приложения
        //Intent intent = new Intent(this, ReceiveMainActivity.class);
        //intent.putExtra(ReceiveMainActivity.EXTRA_MESSAGE, messageText);

        // для вызова активити других приложений устройства
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}