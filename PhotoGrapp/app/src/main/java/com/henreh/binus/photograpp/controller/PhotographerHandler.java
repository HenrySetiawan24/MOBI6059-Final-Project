package com.henreh.binus.photograpp.controller;

import android.content.Context;

import com.henreh.binus.photograpp.DB.Photographer.PhotographerDB;
import com.henreh.binus.photograpp.model.Photographer;

import java.util.Vector;

public class PhotographerHandler {
    PhotographerDB photographerDB;

    public PhotographerHandler(Context ctx){
        photographerDB = new PhotographerDB(ctx);
    }

    public long insert(Photographer photographer){
        return photographerDB.insert(photographer);
    }

    public Boolean Update(int userID, Photographer updatedPhotographer){
        return photographerDB.Update(userID, updatedPhotographer);
    }

    public Boolean delete(int userID){
        return photographerDB.delete(userID);
    }

    public Photographer get(int userID){
        return photographerDB.get(userID);
    }

    public Vector<Photographer> getAll(){
        return photographerDB.getAll();
    }
}
