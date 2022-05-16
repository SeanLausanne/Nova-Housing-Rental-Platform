package com.dalhousie.university.novahousing.repository.user;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.model.Userfactory.model.User;

public interface UserRepository {
    long save(User userDetails);
}
