package com.henreh.binus.photograpp.model;

public class User {
    public long userID;
    public String userName;
    public String userEmail;
    public String userPassword;
    public String locationLatitude;
    public String locationLongitude;
    public String description;
    public String profilePicture;

    public User(){}
    public User(String userName, String userEmail, String userPassword, String locationLatitude, String locationLongitude, String description, String profilePicture){
        this.userName=userName;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.locationLatitude=locationLatitude;
        this.locationLongitude=locationLongitude;
        this.description=description;
        this.profilePicture=profilePicture;
    }
}
