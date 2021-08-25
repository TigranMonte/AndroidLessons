package ru.startandroid.p0422starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {

    public static final String EXTRA_FOODID = "foodid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        // получить еду из данных интента
        int foodId = (Integer)getIntent().getExtras().get(EXTRA_FOODID);
        Food food = Food.foods[foodId];

        // заполнение названия еду
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(food.getName());

        // заполнение описания еду
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(food.getDescription());

        // заполнение изображение еду
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(food.getImageResourceId());
        photo.setContentDescription(food.getName());
    }
}