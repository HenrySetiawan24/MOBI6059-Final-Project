package com.henreh.binus.photograpp.controller;

import android.content.Context;

import com.henreh.binus.photograpp.DB.User.UserDB;
import com.henreh.binus.photograpp.model.User;

public class UserHandler {
    UserDB userDB;

    public UserHandler(Context ctx){
        userDB = new UserDB(ctx);
    }

    public long insert(User user){
        return userDB.insert(user);
    }

    public Boolean Update(int userID, User updatedUser){
        return userDB.Update(userID, updatedUser);
    }

    public Boolean delete(int userID){
        return userDB.delete(userID);
    }

    public User get(int userID){
        return userDB.get(userID);
    }
}
