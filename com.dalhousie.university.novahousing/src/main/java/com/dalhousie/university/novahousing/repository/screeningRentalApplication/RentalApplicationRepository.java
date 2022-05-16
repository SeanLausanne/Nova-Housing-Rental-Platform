//Author: Sidharth
package com.dalhousie.university.novahousing.repository.screeningRentalApplication;

import com.dalhousie.university.novahousing.model.bookViewing.RentalApplication;

import java.util.List;

public interface RentalApplicationRepository {
    public List<RentalApplication> GetRentalApplicationPropertyID(String propertyID);
}
