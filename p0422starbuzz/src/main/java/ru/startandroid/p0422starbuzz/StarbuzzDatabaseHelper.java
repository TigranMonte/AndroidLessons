package ru.startandroid.p0422starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz"; // имя базы данных
    private static final int DB_VERSION = 2;

    StarbuzzDatabaseHelper (Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DRINK");
        db.execSQL("DROP TABLE IF EXISTS FOOD");
        db.execSQL("DROP TABLE IF EXISTS RESTAURANTS");
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertFood(SQLiteDatabase db, String name, String description,
                                   int resourceId) {
        ContentValues foodValues = new ContentValues();
        foodValues.put("NAME", name);
        foodValues.put("DESCRIPTION", description);
        foodValues.put("RESOURCE_ID", resourceId);
        db.insert("FOOD", null, foodValues);
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description,
                                    int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }

    private static void insertRestaurant(SQLiteDatabase db, String name, String description,
                                         int resourceId) {
        ContentValues restaurantValues = new ContentValues();
        restaurantValues.put("NAME", name);
        restaurantValues.put("DESCRIPTION", description);
        restaurantValues.put("RESOURCE_ID", resourceId);
        db.insert("RESTAURANTS", null, restaurantValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE FOOD (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            db.execSQL("CREATE TABLE RESTAURANTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertFood(db, "Pizza", "Pizza with meat, mushrooms and cheese", R.drawable.pizza);
            insertFood(db, "Burger", "Our MegaBurger with cheese and meat", R.drawable.burger);
            insertFood(db, "Barbecue", "Highest quality meat, armenian traditional xorovats",
                    R.drawable.barbeque);
            insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam",
                    R.drawable.cappuccino);
            insertDrink(db, "Filter", "Our best drip coffee", R.drawable.filter);
            insertRestaurant(db, "Starbuzz center", "Arthur Morgan st. 10 Just 2 min " +
                    "from the Valentine metro station", R.drawable.bar2);
            insertRestaurant(db, "Starbuzz park", "St. Denny st. 72, " +
                    "We're next to the Central Park gates", R.drawable.bar3);
            insertRestaurant(db, "Starbuzz sport", "Strawberry road 35, " +
                    "Just 3 min from the City Stadium", R.drawable.bar1);
        }

        if (oldVersion < 2 ) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE FOOD ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE RESTAURANTS ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
