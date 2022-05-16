//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.model.screenRenters.Rental;
import com.dalhousie.university.novahousing.model.bookViewing.RentalApplication;

import java.util.List;

public interface RentalService {
 Rental getRentalData(String propertyID);
 List<RentalApplication> getRentalApplication(String propertyID);
}
