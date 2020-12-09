package com.henreh.binus.photograpp.model;

import java.util.Date;

public class Request {
    public long requestID;
    public long userID;
    public long photographerID;
    public Date eventDate;
    public int status;//1=Pending 2=Active 3=Finished

    public Request(){}

    public Request(long userID, long photographerID, Date eventDate, int status){
        this.userID=userID;
        this.photographerID=photographerID;
        this.eventDate=eventDate;
        this.status=status;
    }
}
