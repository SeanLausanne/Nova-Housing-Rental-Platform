package com.dalhousie.university.novahousing.exception;

// Author- Anita Kumari (B00884141)
public class LoginException extends Exception {

    private String message;
    public LoginException(String message) {
        super(message);
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
