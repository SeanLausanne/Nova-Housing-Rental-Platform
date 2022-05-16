//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RentalScreeningService implements ScreeningService{
    @Override
    public Boolean Screening(UserDetails userDetails, PropertyChecks propertyChecks) {
        if((userDetails.getCredit_score()>=propertyChecks.getMinCreditScore())
               && (userDetails.getAnnual_income()>=propertyChecks.getMinAnnualIncome())
               && (userDetails.isRental_history() == (propertyChecks.isPreferredRentalHistory())
                && userDetails.getUser_status().equals(propertyChecks.getPreferredTenantStatus()))){
            return true;
        }
        return false;
    }
}
