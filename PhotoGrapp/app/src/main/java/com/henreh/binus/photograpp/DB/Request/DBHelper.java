package com.henreh.binus.photograpp.DB.Request;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "RequestDB";
    public static final int DB_VERSION = 1;

    public static String TABLE_NAME_REQUESTS = "request";
    public static String FIELD_REQUEST_ID = "requestID";
    public static String FIELD_USER_ID = "userID";
    public static String FIELD_PHOTOGRAPHER_ID = "photographerID";
    public static String FIELD_EVENT_DATE = "eventDate";
    public static String FIELD_STATUS = "status";

    private static final String create =
            "CREATE TABLE IF NOT EXISTS "+TABLE_NAME_REQUESTS+" (" +
                    FIELD_REQUEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FIELD_USER_ID + " INTEGER," +
                    FIELD_PHOTOGRAPHER_ID + " INTEGER," +
                    FIELD_EVENT_DATE + " TEXT," +
                    FIELD_STATUS + " INTEGER)";

    private static final String drop =
            "DROP TABLE IF EXISTS " + TABLE_NAME_REQUESTS;


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
