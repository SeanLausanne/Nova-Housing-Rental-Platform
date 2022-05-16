package com.dalhousie.university.novahousing.services.login;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.model.login.Login;

public interface LoginService {
    boolean authenticateUser(Login loginObj) throws Exception;
}
