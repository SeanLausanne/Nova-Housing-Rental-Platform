package com.dalhousie.university.novahousing.services.login;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.validations.loginValidation.LoginValidation;
import com.dalhousie.university.novahousing.validations.loginValidation.LoginValidationImpl;
import com.dalhousie.university.novahousing.model.login.Login;
import com.dalhousie.university.novahousing.model.login.LoginUser;
import com.dalhousie.university.novahousing.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    LoginUser userInfo;
    LoginValidation validations;

    @Override
    public boolean authenticateUser(Login loginObj) throws Exception {
        userInfo =loginRepository.getUserByUsername(loginObj.getUsername());
        validations=new LoginValidationImpl(userInfo);
        if(validations.validateLoginUserInput(loginObj)){
            return true;
        }
        return false;
    }
}