package com.henreh.binus.photograpp.DB.Photographer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.henreh.binus.photograpp.model.Photographer;

import java.util.Vector;

public class PhotographerDB {
    DBHelper dbHelper;

    public PhotographerDB(Context ctx){
        dbHelper = new com.henreh.binus.photograpp.DB.Photographer.DBHelper(ctx);
    }

    public long insert(Photographer photographer){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.FIELD_USER_NAME, photographer.userName);
        cv.put(dbHelper.FIELD_USER_EMAIL, photographer.userEmail);
        cv.put(dbHelper.FIELD_USER_PASSWORD, photographer.userPassword);
        cv.put(dbHelper.FIELD_USER_LOCATION_LAT, photographer.locationLatitude);
        cv.put(dbHelper.FIELD_USER_LOCATION_LNG, photographer.locationLongitude);
        cv.put(dbHelper.FIELD_USER_DESCRIPTION, photographer.description);
        cv.put(dbHelper.FIELD_USER_PROFILE_PICTURE, photographer.profilePicture);
        cv.put(dbHelper.FIELD_HIRE_PRICE, photographer.hirePrice);

        long id=db.insert(DBHelper.TABLE_NAME_PHOTOGRAPHERS, null, cv);

        db.close();

        return id;
    }

    public Boolean Update(long userID, Photographer updatedPhotographer){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.FIELD_USER_NAME, updatedPhotographer.userName);
        cv.put(dbHelper.FIELD_USER_EMAIL, updatedPhotographer.userEmail);
        cv.put(dbHelper.FIELD_USER_PASSWORD, updatedPhotographer.userPassword);
        cv.put(dbHelper.FIELD_USER_LOCATION_LAT, updatedPhotographer.locationLatitude);
        cv.put(dbHelper.FIELD_USER_LOCATION_LNG, updatedPhotographer.locationLongitude);
        cv.put(dbHelper.FIELD_USER_DESCRIPTION, updatedPhotographer.description);
        cv.put(dbHelper.FIELD_USER_PROFILE_PICTURE, updatedPhotographer.profilePicture);
        cv.put(dbHelper.FIELD_HIRE_PRICE, updatedPhotographer.hirePrice);

        if(db.update(dbHelper.TABLE_NAME_PHOTOGRAPHERS, cv, selection, selectionArgs)>0){
            return true;
        }
        return false;
    }

    public Boolean delete(long userID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};

        if(db.delete(dbHelper.TABLE_NAME_PHOTOGRAPHERS, selection, selectionArgs)>0){
            return true;
        }
        return false;
    }

    public Photographer get(long userID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};
        Cursor cursor = db.query(DBHelper.TABLE_NAME_PHOTOGRAPHERS, null, selection, selectionArgs, null, null, null);

        Photographer photographer=null;

        if(cursor.moveToFirst()){
            photographer=new Photographer();

            photographer.userID = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_USER_ID));
            photographer.userName = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_NAME));
            photographer.userEmail = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_EMAIL));
            photographer.userPassword = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_PASSWORD));
            photographer.locationLatitude = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_LOCATION_LAT));
            photographer.locationLongitude = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_LOCATION_LNG));
            photographer.description = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_DESCRIPTION));
            photographer.profilePicture = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_PROFILE_PICTURE));
            photographer.hirePrice = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_HIRE_PRICE));
        }

        cursor.close();
        db.close();

        return photographer;
    }

    public Vector<Photographer> getAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DBHelper.TABLE_NAME_PHOTOGRAPHERS, null, null, null, null, null, null);

        Photographer photographer=null;
        Vector<Photographer> photographers = new Vector<>();

        if(cursor.moveToFirst())
            while(cursor.moveToNext()){
                photographer=new Photographer();

                photographer.userID = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_USER_ID));
                photographer.userName = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_NAME));
                photographer.userEmail = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_EMAIL));
                photographer.userPassword = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_PASSWORD));
                photographer.locationLatitude = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_LOCATION_LAT));
                photographer.locationLongitude = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_LOCATION_LNG));
                photographer.description = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_DESCRIPTION));
                photographer.profilePicture = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_PROFILE_PICTURE));
                photographer.hirePrice = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_HIRE_PRICE));

                photographers.add(photographer);
            }

        return photographers;
    }
}
