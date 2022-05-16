package com.dalhousie.university.novahousing.model.Userfactory.model;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.utils.Role;

public interface User {
    long getId();

    void setId(long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getPassword();

    void setPassword(String password);

    String getConfirm_password();

    void setConfirm_password(String confirm_password);

    String getUsername();

    void setUsername(String username);

    String getPhone_number();

    void setPhone_number(String phone_number);

    Role getRole();

    void setRole(Role role);
}
