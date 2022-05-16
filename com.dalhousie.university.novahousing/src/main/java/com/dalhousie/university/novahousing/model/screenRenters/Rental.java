//Author: Sidharth
package com.dalhousie.university.novahousing.model.screenRenters;

import java.util.HashMap;
import java.util.Map;

public class Rental {
    private String RentalID;
    private String PostDate;
    private String RentalType;
    private int RentalArea;
    private int RentalBedroomNumber;
    private String RentalBathroomNumber;
    private String adminApprove;

    public Rental(){}

    public Rental(String rentalID, String postDate, String rentalType, int rentalArea, int rentalBedroomNumber, String rentalBathroomNumber, String adminApprove) {
        this.RentalID = rentalID;
        this.PostDate = postDate;
        this.RentalType = rentalType;
        this.RentalArea = rentalArea;
        this.RentalBedroomNumber = rentalBedroomNumber;
        this.RentalBathroomNumber = rentalBathroomNumber;
        this.adminApprove = adminApprove;
    }


    public String getRentalID() {
        return RentalID;
    }

    public void setRentalID(String rentalID) {
        RentalID = rentalID;
    }

    public String getRentalType() {
        return RentalType;
    }

    public void setRentalType(String rentalType) {
        RentalType = rentalType;
    }

    public int getRentalArea() {
        return RentalArea;
    }

    public void setRentalArea(int rentalArea) {
        RentalArea = rentalArea;
    }

    public int getRentalBedroomNumber() {
        return RentalBedroomNumber;
    }

    public void setRentalBedroomNumber(int rentalBedroomNumber) {
        RentalBedroomNumber = rentalBedroomNumber;
    }

    public String getRentalBathroomNumber() {
        return RentalBathroomNumber;
    }

    public void setRentalBathroomNumber(String rentalBathroomNumber) {
        RentalBathroomNumber = rentalBathroomNumber;
    }

    public Map<String,Object> toMap(){
        Map<String, Object> values= new HashMap<>();
        values.put("id",RentalID);
        values.put("postDate",PostDate);
        values.put("propertyType",RentalType);
        values.put("area",RentalArea);
        values.put("bedroomNumber",RentalBedroomNumber);
        values.put("bathroomNumber",RentalBathroomNumber);
        values.put("adminApproved",adminApprove);
        return values;
    }
}
