package com.dalhousie.university.novahousing.repository.login;
// Author- Anita Kumari (B00884141)

import com.dalhousie.university.novahousing.model.login.LoginUser;

public interface LoginRepository {
    LoginUser getUserByUsername(String username);
}
