//Author: Sidharth
package com.dalhousie.university.novahousing.repository.screeningRentalApplication;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;

public interface PropertyCheckRepository {
    void setPropertyChecks(PropertyChecks propertyChecks) throws FilterNotValidException;
    PropertyChecks getPropertyChecks(String propertyID);
}
