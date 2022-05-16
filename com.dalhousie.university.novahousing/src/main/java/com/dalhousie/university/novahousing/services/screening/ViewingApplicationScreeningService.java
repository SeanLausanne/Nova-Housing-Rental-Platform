//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier
@Primary
public class ViewingApplicationScreeningService implements ScreeningService{
    @Override
    public Boolean Screening(UserDetails userDetails, PropertyChecks propertyChecks) {
        if((userDetails.isRental_history() == (propertyChecks.isPreferredRentalHistory())
                        && userDetails.getUser_status().equals(propertyChecks.getPreferredTenantStatus()))){
        return true;
        }
        return false;
    }
}
