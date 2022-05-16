package com.dalhousie.university.novahousing.exception;

// Author- Anita Kumari (B00884141)
public class AdminException extends Exception{

    private String message;

    public AdminException(String message) {
        super(message);
        this.message=message;
    }
}
