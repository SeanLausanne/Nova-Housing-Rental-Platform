package com.dalhousie.university.novahousing.validations.userRegistrationValidation;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.UserRegistrationException;
import com.dalhousie.university.novahousing.model.Userfactory.model.User;

public interface UserRegistrationValidation {
    boolean validateFirstName(String firstName) throws UserRegistrationException;
    boolean validateLastName(String lastName) throws UserRegistrationException;
    boolean validatePassword(String password) throws UserRegistrationException;
    boolean validateConfirmPassword(String confirmPassword) throws UserRegistrationException;
    boolean validatePasswordConfirmPassword(String password, String confirm_password) throws UserRegistrationException;
    boolean validatePhoneNumber(String phoneNumber) throws UserRegistrationException;
    boolean validateUserRole(String userRole) throws UserRegistrationException;
    boolean validateUsername(String username) throws UserRegistrationException;
    boolean validateUserInput(User userInfo) throws UserRegistrationException;
}
