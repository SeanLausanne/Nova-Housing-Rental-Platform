package com.dalhousie.university.novahousing.validations.loginValidation;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.LoginException;
import com.dalhousie.university.novahousing.model.login.Login;
import com.dalhousie.university.novahousing.utils.Role;

public interface LoginValidation {

    boolean validateUsernameInputs(String username) throws LoginException;
    boolean validatePasswordInputs(String password) throws Exception;
    boolean validateUserExistence() throws LoginException;
    boolean validateUserRole(Role userRole) throws Exception;
    boolean validateLoginUserInput(Login loginObj) throws Exception;


}
