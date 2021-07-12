package ru.startandroid.p0421simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] names = {"Arthur", "Dutch", "Hosea", "John", "Ebi", "Mary", "Charles", "Uncle",
            "Lenny", "Kiran", "Pearson", "Sean"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // создаем адаптер
        // 1 вариант с помощью системного лэйоут ресурса
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, names);

        // создаем адаптер с помощью своего ресурса
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.my_list_item, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);
    }
}