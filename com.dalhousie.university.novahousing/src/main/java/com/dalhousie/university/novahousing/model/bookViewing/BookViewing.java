//Author: Sidharth
package com.dalhousie.university.novahousing.model.bookViewing;

import java.util.HashMap;
import java.util.Map;

public class BookViewing{

    private long bookingID;
    private String propertyID;
    private String visitDate;
    private boolean conformationStatus;
    private String username;


    public BookViewing(){}

    public BookViewing(long bookingID, String propertyID, String visitDate, boolean conformationStatus, String username) {
        this.bookingID=bookingID;
        this.propertyID=propertyID;
        this.visitDate=visitDate;
        this.conformationStatus=conformationStatus;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void setConformationStatus(boolean conformationStatus) {
        this.conformationStatus = conformationStatus;
    }

    public long getBookingID() {
        return bookingID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public boolean isConformationStatus() {
        return conformationStatus;
    }

    public Map<String,Object> toMap(){
        Map<String, Object> values= new HashMap<>();
        values.put("bookingID",bookingID);
        values.put("propertyID",propertyID);
        values.put("visitDate",visitDate);
        values.put("conformationStatus",conformationStatus);
        values.put("username",username);
        return values;
    }

}
