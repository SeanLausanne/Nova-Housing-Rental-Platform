//Author: Sidharth
package com.dalhousie.university.novahousing.validations.bookViewing;

import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;

public interface BookViewingValidation {
    boolean validateUsername(BookViewing bookViewing) throws ApplyException;
    boolean validateBookingID(BookViewing bookViewing) throws ApplyException;

}
