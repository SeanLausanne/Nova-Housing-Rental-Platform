package com.dalhousie.university.novahousing.utils;

// Author- Anita Kumari (B00884141)
public enum Role {
    ROLE_ADMIN ("Admin"),
    ROLE_USER ("User"),
    ROLE_LANDLORD ("Landlord");

    private final String name;

    Role(String name) {
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
