//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.validations.applyRent;

import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;

import java.sql.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateApplyRentImpl implements ValidateApplyRent {

    //validating username
    @Override
    public boolean validateUserName(RentApplication rentApplication) throws ApplyException {
        if (rentApplication.getApplier_username() == null || rentApplication.getApplier_username().isEmpty()) {
            throw new ApplyException("Please provide a name.");
        } else {
            return true;
        }
    }

    //validating moveindate
    @Override
    public boolean validateDate(RentApplication rentApplication) throws ApplyException {
        long d = System.currentTimeMillis();
        Date date = new Date(d);
        if (rentApplication.getMoveInDate() == null || rentApplication.getMoveInDate().before(date)) {
            throw new ApplyException("Please provide valid move in date.");
        } else {
            return true;
        }
    }

    //validating phonenumber
    @Override
    public boolean validatePhonenumber(RentApplication rentApplication) throws ApplyException {

        String phone_number = rentApplication.getPhone_number();
        if (phone_number == null || phone_number.isEmpty()) {
            throw new ApplyException("Please enter phone number.");
        } else {
            Pattern p = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");
            Matcher m = p.matcher(phone_number);
            if (m.matches()) {
                return true;
            } else {
                throw new ApplyException("Please enter valid phone number.");
            }
        }
    }

   //validating animal
    @Override
    public boolean validateAnimal(RentApplication rentApplication) throws ApplyException {
        //System.out.println(rentApplication.getAnimal().toLowerCase(Locale.ROOT));
        String getAnimal = rentApplication.getAnimal().toLowerCase(Locale.ROOT);
        if (getAnimal.equals("yes") || getAnimal.equals("no")) {
            return true;

        } else {
            throw new ApplyException("Please enter valid input.");
        }
    }

    //validating occupants
    @Override
    public boolean validateOccupants(RentApplication rentApplication) throws ApplyException {
        String occupantList = null;
        occupantList = rentApplication.getOccupants();
        if (occupantList == null || occupantList.isEmpty()) {
            throw new ApplyException("Please provide occupants' name.");
        } else {
            return true;
        }
    }

    //validating salary
    @Override
    public boolean validateSalary(RentApplication rentApplication) throws ApplyException {
        int salary = 0;
        salary = rentApplication.getAnnualsalary();
        if (salary == 0) {
            throw new ApplyException("Please enter valid annualSalary.");
        } else if (salary < 1000) {
            throw new ApplyException("Minimum annual salary should be more then 1000.");
        } else {
            return true;
        }
    }
}
