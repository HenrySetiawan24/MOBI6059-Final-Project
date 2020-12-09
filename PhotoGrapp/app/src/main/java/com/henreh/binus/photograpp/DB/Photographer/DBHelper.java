package com.henreh.binus.photograpp.DB.Photographer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static String DB_NAME = "PhotographerDB";
    public static final int DB_VERSION = 1;

    public static String TABLE_NAME_PHOTOGRAPHERS = "photographer";
    public static String FIELD_USER_ID = "userID";
    public static String FIELD_USER_NAME = "userName";
    public static String FIELD_USER_EMAIL = "userEmail";
    public static String FIELD_USER_PASSWORD = "userPassword";
    public static String FIELD_USER_LOCATION_LAT = "locationLatitude";
    public static String FIELD_USER_LOCATION_LNG = "locationLongitude";
    public static String FIELD_USER_DESCRIPTION = "description";
    public static String FIELD_USER_PROFILE_PICTURE = "profilePicture";
    public static String FIELD_HIRE_PRICE = "hirePrice";

    private static final String create =
            "CREATE TABLE IF NOT EXISTS "+TABLE_NAME_PHOTOGRAPHERS+" (" +
                    FIELD_USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_USER_NAME + "TEXT," +
                    FIELD_USER_EMAIL + "TEXT," +
                    FIELD_USER_PASSWORD + "TEXT," +
                    FIELD_USER_LOCATION_LAT + "TEXT," +
                    FIELD_USER_LOCATION_LNG + "TEXT," +
                    FIELD_USER_PROFILE_PICTURE + "TEXT," +
                    FIELD_HIRE_PRICE + "INTEGER)";

    private static final String drop =
            "DROP TABLE IF EXISTS " + TABLE_NAME_PHOTOGRAPHERS;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop);
        onCreate(db);
    }
}
