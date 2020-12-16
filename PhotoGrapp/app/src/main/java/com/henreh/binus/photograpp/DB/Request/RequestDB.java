package com.henreh.binus.photograpp.DB.Request;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.henreh.binus.photograpp.DB.User.UserDB;
import com.henreh.binus.photograpp.model.Request;

import java.sql.Date;
import java.util.Vector;


public class RequestDB {
    DBHelper dbHelper;

    public RequestDB(Context ctx){
        dbHelper = new DBHelper(ctx);
    }

    public long insert(Request request){//validasi di handler: validate userID dan photographerID ada ditabel mereka.
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.FIELD_USER_ID, request.userID);
        cv.put(dbHelper.FIELD_PHOTOGRAPHER_ID, request.photographerID);
        cv.put(dbHelper.FIELD_EVENT_DATE, request.eventDate.toString());
        cv.put(dbHelper.FIELD_STATUS, request.status);

        long id=db.insert(DBHelper.TABLE_NAME_REQUESTS, null, cv);

        db.close();

        return id;
    }

    public Boolean Update(int userID, Request updatedRequest){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+userID};

        ContentValues cv = new ContentValues();

        cv.put(dbHelper.FIELD_USER_ID, updatedRequest.userID);
        cv.put(dbHelper.FIELD_PHOTOGRAPHER_ID, updatedRequest.photographerID);
        cv.put(dbHelper.FIELD_EVENT_DATE, updatedRequest.eventDate.toString());
        cv.put(dbHelper.FIELD_STATUS, updatedRequest.status);

        if(db.update(dbHelper.TABLE_NAME_REQUESTS, cv, selection, selectionArgs)>0){
            return true;
        }
        return false;
    }

    public Boolean delete(int requestID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection ="id=?";
        String[] selectionArgs = {""+requestID};

        if(db.delete(dbHelper.TABLE_NAME_REQUESTS, selection, selectionArgs)>0){
            return true;
        }
        return false;
    }

    public Vector<Request> getAll() //TODO: Ditambah Peter buat bikin getFillteredPhotographer(), Henry tolong taruh logikanya buat ambil data
    {
        return new Vector<Request>();
    }

    public Vector<Request> getAll(int requestID){
        String selection ="requestID=?";
        String[] selectionArgs = {""+requestID};

        return getList(selection, selectionArgs);
    }

    public Vector<Request> getForUser(int userID){
        String selection ="userID=?";
        String[] selectionArgs = {""+userID};

        return getList(selection, selectionArgs);
    }

    public Vector<Request> getForPhotographers(int photographerID){
        String selection ="photographerID=?";
        String[] selectionArgs = {""+photographerID};

        return getList(selection, selectionArgs);
    }

    private Vector<Request> getList(String selection, String[] selectionArgs){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(com.henreh.binus.photograpp.DB.User.DBHelper.TABLE_NAME_USERS, null, selection, selectionArgs, null, null, null);

        Request request=null;

        Vector<Request> requests=null;

        if(cursor.moveToFirst()){
            requests = new Vector<>();
            while(cursor.moveToNext()){
                request=new Request();

                request.requestID = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_REQUEST_ID));
                request.userID = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_USER_ID));
                request.photographerID = cursor.getLong(cursor.getColumnIndex(DBHelper.FIELD_PHOTOGRAPHER_ID));
                request.status = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_STATUS));
                request.eventDate = Date.valueOf(cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_EVENT_DATE)));

                requests.add(request);
            }
        }

        cursor.close();
        db.close();

        return requests;
    }
}
