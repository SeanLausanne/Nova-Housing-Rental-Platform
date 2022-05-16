//Author: Sidharth
package com.dalhousie.university.novahousing.services.rentGenerator;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;

public interface RentGeneratorService {
    int generateRent(String propertyID) throws FilterNotValidException;
}
