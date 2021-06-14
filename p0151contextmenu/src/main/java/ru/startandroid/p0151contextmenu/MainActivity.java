package ru.startandroid.p0151contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvColor, tvSize;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;
    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    //Ниже код с использованием хмл файлов цвета и размера
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.tvColor:
                getMenuInflater().inflate(R.menu.context_menu_color, menu);
                break;
            case R.id.tvSize:
                getMenuInflater().inflate(R.menu.context_menu_size, menu);
                break;
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.color_red:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;
            case R.id.color_green:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;
            case R.id.color_blue:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;
            case R.id.size_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case R.id.size_26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case R.id.size_30:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }
// Ниже код без использования хмл файлов цвета и размера
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case MENU_COLOR_RED:
//                tvColor.setTextColor(Color.RED);
//                tvColor.setText("Text color = Red");
//                break;
//            case MENU_COLOR_GREEN:
//                tvColor.setTextColor(Color.GREEN);
//                tvColor.setText("Text color = Green");
//                break;
//            case MENU_COLOR_BLUE:
//                tvColor.setTextColor(Color.BLUE);
//                tvColor.setText("Text color = Blue");
//                break;
//            case MENU_SIZE_22:
//                tvSize.setTextSize(22);
//                tvSize.setText("Text size = 22");
//                break;
//                case MENU_SIZE_26:
//                tvSize.setTextSize(26);
//                tvSize.setText("Text size = 26");
//                break;
//                case MENU_SIZE_30:
//                tvSize.setTextSize(30);
//                tvSize.setText("Text size = 30");
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        switch (v.getId()) {
//            case R.id.tvColor:
//                menu.add(0,MENU_COLOR_RED, 0, "RED");
//                menu.add(0,MENU_COLOR_GREEN, 0, "GREEN");
//                menu.add(0,MENU_COLOR_BLUE, 0, "BLUE");
//                break;
//            case R.id.tvSize: {
//                menu.add(0,MENU_SIZE_22, 0, "22");
//                menu.add(0,MENU_SIZE_26, 0, "26");
//                menu.add(0,MENU_SIZE_30, 0, "30");
//                break;
//            }
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }
}