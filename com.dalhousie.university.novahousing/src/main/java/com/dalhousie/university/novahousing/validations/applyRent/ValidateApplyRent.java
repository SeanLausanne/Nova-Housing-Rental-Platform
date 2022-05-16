//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.validations.applyRent;

import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;

public interface ValidateApplyRent {
    boolean validateUserName(RentApplication rentApplication) throws ApplyException;
    boolean validateDate(RentApplication rentApplication) throws ApplyException;
    boolean validatePhonenumber(RentApplication rentApplication) throws ApplyException;
    boolean validateAnimal(RentApplication rentApplication) throws ApplyException;
    boolean validateOccupants(RentApplication rentApplication) throws ApplyException;
    boolean validateSalary(RentApplication rentApplication) throws ApplyException;
}
