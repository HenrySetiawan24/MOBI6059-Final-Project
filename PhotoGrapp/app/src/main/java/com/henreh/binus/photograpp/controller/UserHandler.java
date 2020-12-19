package com.henreh.binus.photograpp.controller;

import android.content.Context;

import com.henreh.binus.photograpp.DB.User.UserDB;
import com.henreh.binus.photograpp.model.Photographer;
import com.henreh.binus.photograpp.model.User;

public class UserHandler {
    UserDB userDB;

    PhotographerHandler pHandler;

    public UserHandler(Context ctx){
        userDB = new UserDB(ctx);
        pHandler = new PhotographerHandler(ctx);
    }

    public long insert(User user){
        return userDB.insert(user);
    }

    public Boolean Update(long userID, User updatedUser){
        return userDB.Update(userID, updatedUser);
    }

    public Boolean delete(long userID){
        return userDB.delete(userID);
    }

    public User getOneUser(long userID){
        return userDB.get(userID);
    }

    public boolean validateUserLogin(String userEmail, String password){

        User user= userDB.get(userEmail);

        if(user.userEmail == userEmail && user.userPassword == password) return true;
        else return false;

    }

    public String getRole(long UserID){

        String role = "";

        Photographer temp = pHandler.getOnePhotographer(UserID);

        if(temp != null){
            role = "Photographer";
        }
        else if(temp == null){
            role = "User";
        }

        return role;
    }
}
