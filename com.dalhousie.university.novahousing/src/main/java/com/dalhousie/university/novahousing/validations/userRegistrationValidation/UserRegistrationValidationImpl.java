package com.dalhousie.university.novahousing.validations.userRegistrationValidation;


// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.UserRegistrationException;
import com.dalhousie.university.novahousing.model.Userfactory.model.User;
import com.dalhousie.university.novahousing.utils.Role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidationImpl implements UserRegistrationValidation {


    @Override
    public boolean validateFirstName(String firstName) throws UserRegistrationException {
        if (firstName==null || firstName.isEmpty()) {
            throw new UserRegistrationException("Firstname is required");
        }
        return true;
    }

    @Override
    public boolean validateLastName(String lastName) throws UserRegistrationException {
        if (lastName==null || lastName.isEmpty()) {
            throw new UserRegistrationException("Lastname is required");
        }
        return true;
    }

    @Override
    public boolean validatePassword(String password) throws UserRegistrationException {

        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);

        if(password==null || password.isEmpty()){
            throw new UserRegistrationException("Password is required");
        }
        else {
            Matcher matcher = pattern.matcher(password);
            if(matcher.find()){
                return true;
            }
            else{
                throw new UserRegistrationException("Password should be of minimum length 8 and must contain atleast a special character,a number, a uppercase letter and a smallcase letter");
            }
        }
    }

    @Override
    public boolean validateConfirmPassword(String confirmPassword) throws UserRegistrationException {

        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);

        if(confirmPassword==null ||confirmPassword.isEmpty()){
            throw new UserRegistrationException("Confirm Password is required");
        }
        else {
            Matcher matcher = pattern.matcher(confirmPassword);
            if(matcher.find()){
                return true;
            }
            else{
                throw new UserRegistrationException("Confirm Password should be of minimum length 8 and must contain atleast a special character,a number, a uppercase letter and a smallcase letter");
            }
        }
    }

    @Override
    public boolean validatePasswordConfirmPassword(String password, String confirm_password) throws UserRegistrationException {

        if (confirm_password.equals(password)) {
            return true;
        } else throw new UserRegistrationException("Confirm Password and Password did not match");
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) throws UserRegistrationException {
       // phone_number = userDetails.getPhone_number();
        String regex = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
        Pattern pattern = Pattern.compile(regex);


        if(phoneNumber==null || phoneNumber.isEmpty()){
            throw new UserRegistrationException("Phone number is required");
        }
        else{
            Matcher matcher = pattern.matcher(phoneNumber);
            if(matcher.matches()){
                return true;
            }
            else throw new UserRegistrationException("Invalid Phone number");
        }
    }

    @Override
    public boolean validateUserRole(String userRole) throws UserRegistrationException {
        int found=0;
        if (userRole==null || userRole.isEmpty()) {
            throw new UserRegistrationException("Role not selected");
        }
        else{

            for(Role r:Role.values()){
                System.out.println(r.getName()+"hello get name");
                if(r.toString().equals(userRole)){
                    found=1;
                    break;
                }
            }
        }

        if(found==0){
            throw new UserRegistrationException("Not a valid user role");
        }
        return true;
    }

    @Override
    public boolean validateUsername(String username) throws UserRegistrationException {
        int notFound=0;
        if (username==null || username.isEmpty()) {
            throw new UserRegistrationException("Username is mandatory");
        }
        else{
            String regex = "^^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(username);

            if(matcher.matches()){
                return true;
            }
            else throw new UserRegistrationException("Pleas enter valid username");
        }
    }

    @Override
    public boolean validateUserInput(User userInfo) throws UserRegistrationException {
        int result=0;
        if(this.validateFirstName(userInfo.getFirstName())){
            result=1;
        }
        if(result==1 && this.validateLastName(userInfo.getLastName())){
            result=2;
        }
        if(result==2 && this.validatePassword(userInfo.getPassword())){
            result=3;
        }

        if(result==3 && this.validateConfirmPassword(userInfo.getConfirm_password())){
            result=4;
        }

        if(result==4 && this.validatePasswordConfirmPassword(userInfo.getPassword(), userInfo.getConfirm_password())){
            result=5;
        }

        if(result==5 && this.validatePhoneNumber(userInfo.getPhone_number())){
            result=6;
        }

        if(result==6 && this.validateUserRole(userInfo.getRole().toString())){
            result=7;
        }

        if(result==7 && this.validateUsername(userInfo.getUsername())){
            result=8;
        }

        return result==8?true:false;
    }
}
