package ru.startandroid.p0451expandablelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // названия компаний (групп)
    String[] groups = new String[] {"Italy", "England", "Spain"};

    // названия клубов (элементы)
    String[] clubsItaly = new String[] {"Milan", "Juventus", "Inter", "Roma", "Lazio"};
    String[] clubsEngland = new String[] {"ManUTD", "Arsenal", "Chelsea", "Liverpool", "ManCity"};
    String[] clubsSpain = new String[] {"Real Madrid", "Barcelona", "Atletico", "Sevilla", "Athletic"};

    // коллекция для групп
    ArrayList<Map<String, String>> groupData;
    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;
    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;

    // список аттрибутов группы или элемента
    Map<String, String> m;

    ExpandableListView elvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // заполняем список аттрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put("groupName", group); // имя компании
            groupData.add(m);
        }
        // список аттрибутов групп для чтения
        String groupFrom[] = new String[] {"groupName"};
        // список ID view-элементов, в которые будут помещены аттрибуты групп
        int groupTo[] = new int [] {android.R.id.text1};

        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список аттрибутов для каждого элемента
        for (String club : clubsItaly) {
            m = new HashMap<String, String>();
            m.put("clubName", club); // название клуба
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для второй группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список аттрибутов для каждого элемента
        for (String club : clubsEngland) {
            m = new HashMap<String, String>();
            m.put("clubName", club); // название клуба
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список аттрибутов для каждого элемента
        for (String club : clubsSpain) {
            m = new HashMap<String, String>();
            m.put("clubName", club); // название клуба
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // список аттрибутов элементов для чтения
        String childFrom[] = new String[] {"clubName"};
        // список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,
                groupData, android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo,
                childData, android.R.layout.simple_list_item_1, childFrom, childTo);

        elvMain = (ExpandableListView) findViewById(R.id.eLvMain);
        elvMain.setAdapter(adapter);
    }
}