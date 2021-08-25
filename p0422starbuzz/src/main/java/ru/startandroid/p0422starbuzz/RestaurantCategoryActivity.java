package ru.startandroid.p0422starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RestaurantCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_category);

        ArrayAdapter<Restaurant> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Restaurant.restaurants);
        ListView listRestaurants = (ListView) findViewById(R.id.list_restaurants);
        listRestaurants.setAdapter(listAdapter);

        // создание слушателя
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listRestaurants, View itemView, int position, long id) {
                // передача еды, выбранного пользователем, FoodActivity
                Intent intent = new Intent(RestaurantCategoryActivity.this, RestaurantActivity.class);
                intent.putExtra(RestaurantActivity.EXTRA_RESTAURANTID, (int) id);
                startActivity(intent);
            }
        };
        // назначение слушателя для спискового представления
        listRestaurants.setOnItemClickListener(itemClickListener);
    }
}