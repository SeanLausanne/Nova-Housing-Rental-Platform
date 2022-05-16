package com.dalhousie.university.novahousing.controller.dto;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.utils.Role;
import java.util.HashMap;
import java.util.Map;

public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String confirm_password;
    private String username;
    private String phone_number;
    private Role role;


    public UserDto(){}

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDto(Long id, String firstName, String lastName, String password, String confirm_password, String username, String phone_number, Role role) {
        // this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirm_password = confirm_password;
        this.username = username;
        this.phone_number = phone_number;
        this.role = role;
    }



    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("firstName", firstName);
        values.put("lastName", lastName);
        values.put("password", password);
        values.put("confirm_password", confirm_password);
        values.put("username", username);
        values.put("phone_number", phone_number);
        values.put("role", role);
        return values;
    }
}
