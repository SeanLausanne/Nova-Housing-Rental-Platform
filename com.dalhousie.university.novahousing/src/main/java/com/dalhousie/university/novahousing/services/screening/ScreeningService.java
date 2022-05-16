//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;

public interface ScreeningService {
 Boolean Screening(UserDetails userDetails, PropertyChecks propertyChecks);
}
