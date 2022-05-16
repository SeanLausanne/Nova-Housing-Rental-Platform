package com.dalhousie.university.novahousing.model.login;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.utils.Role;

public class Login {
    private String username;
    private String password;
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Login(){}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
