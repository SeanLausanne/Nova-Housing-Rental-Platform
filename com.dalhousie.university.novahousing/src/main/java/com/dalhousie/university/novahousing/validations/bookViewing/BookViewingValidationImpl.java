//Author: Sidharth
package com.dalhousie.university.novahousing.validations.bookViewing;

import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;

public class BookViewingValidationImpl implements BookViewingValidation{
    @Override
    public boolean validateUsername(BookViewing bookViewing) throws ApplyException {
        if(bookViewing.getUsername() == null || bookViewing.getUsername().isEmpty() ){
            throw new ApplyException("Please provide a name.");
        }
        else {
            return true;
        }
    }

    @Override
    public boolean validateBookingID(BookViewing bookViewing) throws ApplyException {
        if(bookViewing.getUsername() == null || bookViewing.getUsername().isEmpty() ){
            throw new ApplyException("Please provide bookingID.");
        }
        else {
            return true;
        }
    }
}
