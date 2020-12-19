package com.henreh.binus.photograpp.DB.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.henreh.binus.photograpp.model.User;

public class UserDB {
    DBHelper dbHelper;

    public UserDB(Context ctx){
        dbHelper = new DBHelper(ctx);
    }

    public long insert(User user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.FIELD_USER_NAME, user.userName);
        cv.put(dbHelper.FIELD_USER_EMAIL, user.userEmail);
        cv.put(dbHelper.FIELD_USER_PASSWORD, user.userPassword);
        cv.put(dbHelper.FIELD_USER_LOCATION_LAT, user.locationLatitude);
        cv.put(dbHelper.FIELD_USER_LOCATION_LNG, user.locationLongitude);
        cv.put(dbHelper.FIELD_USER_DESCRIPTION, user.description);
        cv.put(dbHelper.FIELD_USER_PROFILE_PICTURE, user.profilePicture);

        long id=db.insert(DBHelper.TABLE_NAME_USERS, null, cv);

        db.close();

        return id;
    }

    public Boolean Update(long userID, User updatedUser){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.FIELD_USER_NAME, updatedUser.userName);
        cv.put(dbHelper.FIELD_USER_EMAIL, updatedUser.userEmail);
        cv.put(dbHelper.FIELD_USER_PASSWORD, updatedUser.userPassword);
        cv.put(dbHelper.FIELD_USER_LOCATION_LAT, updatedUser.locationLatitude);
        cv.put(dbHelper.FIELD_USER_LOCATION_LNG, updatedUser.locationLongitude);
        cv.put(dbHelper.FIELD_USER_DESCRIPTION, updatedUser.description);
        cv.put(dbHelper.FIELD_USER_PROFILE_PICTURE, updatedUser.profilePicture);

        if(db.update(dbHelper.TABLE_NAME_USERS, cv, selection, selectionArgs)>0){
            return true;
        }
        return false;
    }

    public Boolean delete(long userID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};

        if(db.delete(dbHelper.TABLE_NAME_USERS, selection, selectionArgs)>0){
            return true;
        }
        return false;
    }

    public User get(long userID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};
        Cursor cursor = db.query(DBHelper.TABLE_NAME_USERS, null, selection, selectionArgs, null, null, null);

        User user=null;

        if(cursor.moveToFirst()){
            user=new User();

            user.userID = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_USER_ID));
            user.userName = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_NAME));
            user.userEmail = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_EMAIL));
            user.userPassword = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_PASSWORD));
            user.locationLatitude = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_LOCATION_LAT));
            user.locationLongitude = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_LOCATION_LNG));
            user.description = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_DESCRIPTION));
            user.profilePicture = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_USER_PROFILE_PICTURE));
        }

        cursor.close();
        db.close();

        return user;
    }

    public User get(String userEmail){ //TODO: Henry, tolong tambahin logika buat nyari User dengan email yg di argumentasikan

        User user = new User();

        return user;
    }
}
