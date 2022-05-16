//Author: Sidharth
package com.dalhousie.university.novahousing.model.screenRenters;

public class PropertyChecks {

    private String propertyID;
    private int rent;
    private int minAnnualIncome;
    private String preferredTenantStatus;
    private boolean preferredRentalHistory;
    private int minCreditScore;

    public  PropertyChecks(){}

    public PropertyChecks(String propertyID, int rent, int minAnnualIncome, String preferredTenantStatus, boolean preferredRentalHistory, int minCreditScore) {
        this.propertyID = propertyID;
        this.rent = rent;
        this.minAnnualIncome = minAnnualIncome;
        this.preferredTenantStatus = preferredTenantStatus;
        this.preferredRentalHistory = preferredRentalHistory;
        this.minCreditScore = minCreditScore;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMinAnnualIncome() {
        return minAnnualIncome;
    }

    public void setMinAnnualIncome(int minAnnualIncome) {
        this.minAnnualIncome = minAnnualIncome;
    }

    public String getPreferredTenantStatus() {
        return preferredTenantStatus;
    }

    public void setPreferredTenantStatus(String preferredTenantStatus) {
        this.preferredTenantStatus = preferredTenantStatus;
    }

    public boolean isPreferredRentalHistory() {
        return preferredRentalHistory;
    }

    public void setPreferredRentalHistory(boolean preferredRentalHistory) {
        this.preferredRentalHistory = preferredRentalHistory;
    }

    public int getMinCreditScore() {
        return minCreditScore;
    }

    public void setMinCreditScore(int minCreditScore) {
        this.minCreditScore = minCreditScore;
    }
}
