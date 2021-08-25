package ru.startandroid.p0422starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {

    public static final String EXTRA_RESTAURANTID = "restaurantid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        // получить ресторан из данных интента
        int restaurantId = (Integer)getIntent().getExtras().get(EXTRA_RESTAURANTID);
        Restaurant restaurant = Restaurant.restaurants[restaurantId];

        // заполнение названия ресторана
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(restaurant.getName());

        // заполнение описания ресторана
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(restaurant.getDescription());

        // заполнение изображения ресторана
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(restaurant.getImageResourceId());
        photo.setContentDescription(restaurant.getName());
    }
}