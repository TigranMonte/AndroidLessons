package ru.startandroid.p0521cursorloader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int CM_DELETE_ID = 1;
    ListView lvData;
    DB db;
    SimpleCursorAdapter scAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // открываем подключение к БД
        db = new DB(this);
        db.open();
        // формируем столбцы сопоставления
        String[] from = new String[] {DB.COLUMN_IMG, DB.COLUMN_TXT };
        int[] to = new int[] {R.id.ivImg, R.id.lvData};
        // создаем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);
        lvData = findViewById(R.id.lvData);
        lvData.setAdapter(scAdapter);
        // добавляем контекстное меню к списку
        registerForContextMenu(lvData);
        // создаем лоадер для чтения данных
        LoaderManager.getInstance(this).initLoader(0,null, this);
    }
    // обработка нажатия кнопки
    public void onButtonClick(View view) {
        // добавляем запись
        db.addRec("someText " + (scAdapter.getCount() + 1), R.mipmap.ic_launcher);
        // получаем новый курсор с данными
        LoaderManager.getInstance(this).getLoader(0).forceLoad();
    }
    // создаем контектсное меню
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,CM_DELETE_ID, 0, R.string.delete_record);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == CM_DELETE_ID) {
            // получаем из пункта контекстного меню данные по пункту списка
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            // извлекаем id записи и удаляем соответствующую запись в БД
            db.delRec(acmi.id);
            // получаем новый курсос с данными
            LoaderManager.getInstance(this).getLoader(0).forceLoad();
            return true;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // закрываем подключение при выходе
        db.close();
    }
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bndl) {
        return new MyCursorLoader(this, db);
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        scAdapter.swapCursor(cursor);
    }
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
    static class MyCursorLoader extends CursorLoader {
        DB db;

        public MyCursorLoader(Context context, DB db) {
            super(context);
            this.db = db;
        }
        public Cursor loadInBackground() {
            Cursor cursor = db.getAllData();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return cursor;
        }
    }
}