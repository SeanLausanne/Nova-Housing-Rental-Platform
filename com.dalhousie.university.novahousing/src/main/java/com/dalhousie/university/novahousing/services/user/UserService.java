package com.dalhousie.university.novahousing.services.user;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.model.Userfactory.model.User;

public interface UserService {
    long registerUser(User userDetails) throws Exception;
}
