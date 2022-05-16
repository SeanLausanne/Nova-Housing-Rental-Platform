//Author: Sidharth
package com.dalhousie.university.novahousing.model.bookViewing;

import java.util.HashMap;
import java.util.Map;

public class RentalApplication {
    private int id;
    private String applier_username;
    private String propertyId;
    private String MoveInDate;
    private String phone_number;
    private String animal;
    private String occupants;
    private String annualsalary;

    public RentalApplication(){}

    public RentalApplication(int id, String applier_username, String propertyId, String moveInDate, String phone_number, String animal, String occupants, String annualsalary) {
        this.id = id;
        this.applier_username = applier_username;
        this.propertyId = propertyId;
        this.MoveInDate = moveInDate;
        this.phone_number = phone_number;
        this.animal = animal;
        this.occupants = occupants;
        this.annualsalary = annualsalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplier_username() {
        return applier_username;
    }

    public void setApplier_username(String applier_username) {
        this.applier_username = applier_username;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getMoveInDate() {
        return MoveInDate;
    }

    public void setMoveInDate(String moveInDate) {
        MoveInDate = moveInDate;
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

    public String getAnnualsalary() {
        return annualsalary;
    }

    public void setAnnualsalary(String annualsalary) {
        this.annualsalary = annualsalary;
    }

    public Map<String,Object> toMap(){

        Map<String, Object> values= new HashMap<>();
        values.put("id",id);
        values.put("applier_username",applier_username);
        values.put("propertyId", propertyId);
        values.put("MoveInDate",MoveInDate);
        values.put("phone_number",phone_number);
        values.put("animal",animal);
        values.put("occupants",occupants);
        values.put("annualsalary",annualsalary);
        return values;
    }

}
