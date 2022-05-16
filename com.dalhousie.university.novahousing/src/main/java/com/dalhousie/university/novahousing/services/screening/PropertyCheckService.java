//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;

public interface PropertyCheckService {
    void settingUpPropertyCheck(PropertyChecks propertyChecks) throws FilterNotValidException;
    PropertyChecks getPropertyChecks(String propertyID);
}
