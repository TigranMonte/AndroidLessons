package ru.startandroid.p0562findbeer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        // получить ссылку на TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        // получить ссылку на Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // получить вариант, выбранный в Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        // получить рекомендации от класса BeerExpert
        List<String> brandList = expert.getBrands(beerType); // получить контейнер Лист с сортами пива
        StringBuilder brandsFormatted = new StringBuilder(); // построить Стринг по данным Лист
        for (String brand : brandList) {
            brandsFormatted.append(brand).append('\n');
        }
        // вывести сорта пива
        brands.setText(brandsFormatted);
    }
}