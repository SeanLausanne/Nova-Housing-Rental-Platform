//Author: Sidharth
package com.dalhousie.university.novahousing.model.screenRenters;

import java.util.HashMap;
import java.util.Map;

public class UserDetails {

    private String username;
    private int credit_score;
    private String user_status;
    private int annual_income;
    private boolean rental_history;

    public UserDetails(){
    }
    public UserDetails(String username, int credit_score, String user_status, int annual_income, boolean rental_history){
        this.username=username;
        this.credit_score=credit_score;
        this.user_status=user_status;
        this.annual_income=annual_income;
        this.rental_history=rental_history;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(int credit_score) {
        this.credit_score = credit_score;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public int getAnnual_income() {
        return annual_income;
    }

    public void setAnnual_income(int annual_income) {
        this.annual_income = annual_income;
    }

    public boolean isRental_history() {
        return rental_history;
    }

    public void setRental_history(boolean rental_history) {
        this.rental_history = rental_history;
    }

    public Map<String,Object> toMap(){
        Map<String, Object> values= new HashMap<>();
        values.put("username",username);
        values.put("credit_score",credit_score);
        values.put("user_status",user_status);
        values.put("annual_income",annual_income);
        values.put("rental_history",rental_history);
        return values;
    }
}
