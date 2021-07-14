package com.example.p0461expandablelistevents;

import android.content.Context;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterHelper {

    final String ATTR_GROUP_NAME = "groupName";
    final String ATTR_PHONE_NAME = "phoneName";

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

    Context context;

    AdapterHelper(Context _context) {
        context = _context;
    }

    SimpleExpandableListAdapter adapter;
    SimpleExpandableListAdapter getAdapter() {

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

        adapter = new SimpleExpandableListAdapter(context, groupData,
                android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo, childData,
                android.R.layout.simple_list_item_1, childFrom, childTo);

        return adapter;
    }
    String getGroupText(int groupPos) {
        return ((Map<String, String>)(adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }
    String getChildText(int groupPos, int childPos) {
        return ((Map<String, String>) (adapter.getChild(groupPos, childPos))).get(ATTR_PHONE_NAME);
    }
    String getGroupChildText(int groupPos, int childPos) {
        return getGroupText(groupPos) + " " + getChildText(groupPos, childPos);
    }
}
