package com.dalhousie.university.novahousing.validations.loginValidation;


// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.LoginException;
import com.dalhousie.university.novahousing.model.login.Login;
import com.dalhousie.university.novahousing.model.login.LoginUser;
import com.dalhousie.university.novahousing.utils.AESEncryption;
import com.dalhousie.university.novahousing.utils.Role;

import static java.util.Objects.isNull;

public class LoginValidationImpl implements LoginValidation{

    private LoginUser loginUserDetails;

    public LoginValidationImpl(){}

    public LoginValidationImpl(LoginUser loginUserInfo){
        loginUserDetails = loginUserInfo;
    }


    @Override
    public boolean validateUsernameInputs(String username) throws LoginException {
        if(isNull(username) || username.isEmpty()){
            throw new LoginException("Username is mandatory");
        }
        return true;
    }

    @Override
    public boolean validatePasswordInputs(String password) throws Exception {
        if(isNull(password) || password.isEmpty()){
            throw new LoginException("Password not provided");
        }
        else{
            System.out.println(loginUserDetails);
            if (AESEncryption.decrypt(loginUserDetails.getPassword()).equals(password)) {
                return true;
            }
            throw new LoginException("Password did not match");
        }
    }

    @Override
    public boolean validateUserExistence() throws LoginException {
        if(isNull(loginUserDetails)){
            throw new LoginException("User doesn't exists");
        }
        return true;
    }



    @Override
    public boolean validateUserRole(Role userRole) throws Exception {
        if (loginUserDetails.getRole().toString().equals(userRole.toString())) {
            return true;
        }
        throw new LoginException("Not authorized to visit");
    }


    @Override
    public boolean validateLoginUserInput(Login loginObj) throws Exception {
        int result=0;
        if(this.validateUsernameInputs(loginObj.getUsername())){
            result=1;
        }
        if(result==1 && this.validatePasswordInputs(loginObj.getPassword())){
            result=2;
        }

        if(result==2 && this.validateUserRole(loginObj.getRole())){
            result=3;
        }

        if(result==3 && this.validateUserExistence()){
            result=4;
        }

        return result==4?true:false;
    }
}
