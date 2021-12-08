package ru.startandroid.p0422starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantActivity extends AppCompatActivity {

    public static final String EXTRA_RESTAURANTID = "restaurantid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        // получить ресторан из данных интента
        int restaurantId = (Integer)getIntent().getExtras().get(EXTRA_RESTAURANTID);
        // создание курсора
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("RESTAURANTS", new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?", new String[] {Integer.toString(restaurantId)}, null, null, null);

            // переход к первой записи в курсоре
            if (cursor.moveToFirst()) {
                // получение данных restaurant из курсора
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);

                // заполнение названия restaurant
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                // заполнение описание restaurant
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                // заполнение изображения restaurant
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}