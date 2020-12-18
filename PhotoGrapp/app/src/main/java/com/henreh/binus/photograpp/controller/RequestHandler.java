package com.henreh.binus.photograpp.controller;

import android.content.Context;

import com.henreh.binus.photograpp.DB.Photographer.PhotographerDB;
import com.henreh.binus.photograpp.DB.Request.RequestDB;
import com.henreh.binus.photograpp.DB.User.UserDB;
import com.henreh.binus.photograpp.model.Request;

import java.util.Vector;

public class RequestHandler {
    RequestDB requestDB;
    UserDB userDB;
    PhotographerDB photographerDB;

    public RequestHandler(Context ctx){
        requestDB = new RequestDB(ctx);
    }

    public long insert(Request request){//validasi di handler: validate userID dan photographerID ada ditabel mereka.

        if (userDB.get((int) request.userID) != null && photographerDB.get((int) request.photographerID) != null){
            return requestDB.insert(request);
        }

        return -1;
    }

    public Boolean Update(int userID, Request updatedRequest){
        return requestDB.Update(userID, updatedRequest);
    }

    public Boolean delete(int requestID){
        return requestDB.delete(requestID);
    }

    public Vector<Request> getAll(){ return requestDB.getAll();} //Ditambah Peter buat bikin getFillteredPhotographer()

    public Vector<Request> getAll(int requestID){
        return requestDB.getAll(requestID);
    }

    public Vector<Request> getForUser(int userID){
        return requestDB.getForUser(userID);
    }

    public Vector<Request> getRequestsForPhotographers(int photographerID){
        return requestDB.getForPhotographers(photographerID);
    }

    public Vector<Request> getPendingRequestsForUser(Integer userID){

        Vector<Request> allRequests = requestDB.getAll(userID);

        Vector<Request> pendingRequests = new Vector<>();

        for (Request r: allRequests) {
            if(r.status == 1){
                pendingRequests.add(r);
            }
        }
        return pendingRequests;
    }

    public Vector<Request> getActiveRequestsForUser(Integer userID){

        Vector<Request> allRequests = requestDB.getAll(userID);

        Vector<Request> activeRequests = new Vector<>();

        for (Request r: allRequests) {
            if(r.status == 2){
                activeRequests.add(r);
            }
        }
        return activeRequests;
    }

    public Vector<Request> getFinishedRequestsForUser(Integer userID){
        Vector<Request> allRequests = requestDB.getAll(userID);

        Vector<Request> finishedRequests = new Vector<>();

        for (Request r: allRequests) {
            if(r.status == 3){
                finishedRequests.add(r);
            }
        }
        return finishedRequests;
    }
}
