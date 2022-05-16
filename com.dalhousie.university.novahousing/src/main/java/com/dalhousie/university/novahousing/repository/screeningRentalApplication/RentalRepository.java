//Author: Sidharth
package com.dalhousie.university.novahousing.repository.screeningRentalApplication;

import com.dalhousie.university.novahousing.model.screenRenters.Rental;

public interface RentalRepository {
    Rental getRentalDetails(String propertyID);
}
