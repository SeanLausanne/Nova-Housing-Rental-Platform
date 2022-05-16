//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.model.rentApplication;

import java.sql.Date;

public class RentApplication {
    long id;
    String applier_username;
    String propertyId;
    Date moveInDate; 
    String phone_number;
    String animal;
    String occupants;
    int annualsalary;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplier_username() {
        return applier_username;
    }

    public void setApplier_username(String applier_username) {
        this.applier_username = applier_username;
    }


    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getOccupants() {
        return occupants;
    }

    public void setOccupants(String occupants) {
        this.occupants = occupants;
    }

    public int getAnnualsalary() {
        return annualsalary;
    }

    public void setAnnualsalary(int annualsalary) {
        this.annualsalary = annualsalary;
    }
}
