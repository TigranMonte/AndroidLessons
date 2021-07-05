package ru.startandroid.p0342tvseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText title_input, genre_input, seasons_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        genre_input = findViewById(R.id.genre_input);
        seasons_input = findViewById(R.id.seasons_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addSeries(title_input.getText().toString().trim(),
                        genre_input.getText().toString().trim(),
                        Integer.valueOf(seasons_input.getText().toString().trim()));
            }
        });
    }
}