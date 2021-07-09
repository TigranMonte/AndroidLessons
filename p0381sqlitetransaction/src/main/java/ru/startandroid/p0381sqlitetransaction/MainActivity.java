package ru.startandroid.p0381sqlitetransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String DB_NAME = "myDB";
    private static final String TABLE_NAME = "MyTable";
    private SQLiteDatabase database;
    TextView tvTime;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDB();
        tvTime = (TextView) findViewById(R.id.tvTime);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);
    }

    private void initDB() {
        database = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (FirstNumber INT, SecondNumber INT, Result INT);");
        database.delete(TABLE_NAME, null, null);
    }

    @Override
    public void onClick(View v) {
        database.delete(TABLE_NAME, null, null);
        long startTime = System.currentTimeMillis();
        insertRecords();
        long diffTime = System.currentTimeMillis() - startTime;
        tvTime.setText("Time :" + Long.toString(diffTime) + " ms");

    }

    private void insertRecords() {
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?);";
        SQLiteStatement statement = database.compileStatement(sql);
        database.beginTransaction();
        try {
            for (int i = 0; i < 1000; i++) {
                statement.clearBindings();
                statement.bindLong(1, i);
                statement.bindLong(2, i);
                statement.bindLong(3, i*i);

                statement.execute();
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    @Override
    protected void onDestroy() {
        database.close();
        super.onDestroy();
    }
}