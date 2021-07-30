package ru.startandroid.p0571gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    GridView gvMain;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, data);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }

    private void adjustGridView() {
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(50);
        gvMain.setHorizontalSpacing(5);
        gvMain.setVerticalSpacing(5);
        //gvMain.setStretchMode(GridView.NO_STRETCH); свободное пространство не используется
        gvMain.setStretchMode(GridView.STRETCH_COLUMN_WIDTH); //про-во справа, испол-ся режим по умолчанию
        //gvMain.setStretchMode(GridView.STRETCH_SPACING); пр-во равномерно растянуто между столбцами
        //gvMain.setStretchMode(GridView.STRETCH_SPACING_UNIFORM); пр-во и справа и слева распределено
    }
}