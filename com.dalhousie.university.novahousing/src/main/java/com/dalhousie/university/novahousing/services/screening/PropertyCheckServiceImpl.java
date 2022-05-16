//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.repository.screeningRentalApplication.PropertyCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyCheckServiceImpl implements PropertyCheckService{

    @Autowired
    PropertyCheckRepository propertyCheckRepositoryImpl;

    @Override
    public void settingUpPropertyCheck(PropertyChecks propertyChecks) throws FilterNotValidException {
        propertyCheckRepositoryImpl.setPropertyChecks(propertyChecks);
    }

    @Override
    public PropertyChecks getPropertyChecks(String propertyID) {
       return propertyCheckRepositoryImpl.getPropertyChecks(propertyID);
    }
}
