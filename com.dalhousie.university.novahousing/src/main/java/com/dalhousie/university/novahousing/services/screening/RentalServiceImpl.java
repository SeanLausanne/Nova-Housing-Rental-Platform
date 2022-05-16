//Author: Sidharth
package com.dalhousie.university.novahousing.services.screening;

import com.dalhousie.university.novahousing.model.screenRenters.Rental;
import com.dalhousie.university.novahousing.model.bookViewing.RentalApplication;
import com.dalhousie.university.novahousing.repository.screeningRentalApplication.RentalApplicationRepository;
import com.dalhousie.university.novahousing.repository.screeningRentalApplication.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{

    @Autowired
    RentalRepository rentalRepositoryImpl;

    @Autowired
    RentalApplicationRepository rentalApplicationRepositoryImpl;

    @Override
    public Rental getRentalData(String propertyID) {
       return rentalRepositoryImpl.getRentalDetails(propertyID);
    }

    @Override
    public List<RentalApplication> getRentalApplication(String propertyID) {
        return rentalApplicationRepositoryImpl.GetRentalApplicationPropertyID(propertyID);
    }

    public List<Rental> RecommendedRentalApplication(String propertyID) {

        List<Rental> RecommendedRentalApplications =new ArrayList<>();

        Rental viewing_applications= rentalRepositoryImpl.getRentalDetails(propertyID);
//        for (BookViewing viewing_application : viewing_applications) {
//
//            UserDetails userDetails= userDetailsService.getDetails(viewing_application.getUsername());
//            PropertyChecks propertyChecks=propertyCheckService.getPropertyChecks(propertyID);
//
//            if(screeningService.Screening(userDetails,propertyChecks)){
//                RecommendedRentalApplications.add(viewing_application);}
//        }
      return RecommendedRentalApplications;
    }
}

