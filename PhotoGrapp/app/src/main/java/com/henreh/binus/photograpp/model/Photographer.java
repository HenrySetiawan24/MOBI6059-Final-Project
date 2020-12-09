package com.henreh.binus.photograpp.model;

public class Photographer extends User{
    public Long hirePrice;

    public Photographer(){}

    public Photographer(String userName, String userEmail, String userPassword, String locationLatitude, String locationLongitude, String description, String profilePicture, Long hirePrice){
        super(userName, userEmail, userPassword, locationLatitude, locationLongitude, description, profilePicture);
        this.hirePrice=hirePrice;
    }
}
