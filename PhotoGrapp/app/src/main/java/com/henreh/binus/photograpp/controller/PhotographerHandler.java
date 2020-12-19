package com.henreh.binus.photograpp.controller;

import android.content.Context;

import com.henreh.binus.photograpp.DB.Photographer.PhotographerDB;
import com.henreh.binus.photograpp.DB.Request.RequestDB;
import com.henreh.binus.photograpp.model.Photographer;
import com.henreh.binus.photograpp.model.Request;

import java.util.Vector;

public class PhotographerHandler {
    PhotographerDB photographerDB;
    RequestHandler requestHandler;

    public PhotographerHandler(Context ctx){

        photographerDB = new PhotographerDB(ctx);
    }

    public long insert(Photographer photographer){
        return photographerDB.insert(photographer);
    }

    public Boolean Update(long userID, Photographer updatedPhotographer){
        return photographerDB.Update(userID, updatedPhotographer);
    }

    public Boolean delete(long userID){
        return photographerDB.delete(userID);
    }

    public Photographer getOnePhotographer(long userID){
        return photographerDB.get(userID);
    }

    public Vector<Photographer> getAllPhotographers(){
        return photographerDB.getAll();
    }

    public Vector<Request> getFilteredPhotographer(Integer photographerID){ //TODO: Henry tolong cek ulang, ini sesuai  yg lu jelasin atau enggak

        Vector<Request> filteredList = new Vector<>();
        Vector<Request> requestList = requestHandler.getAll();

        for (Request r: requestList) {
            if(r.photographerID == photographerID){
                requestList.add(r);
            }
        }

        return requestList;
    }
}
