//Author: Sidharth
package com.dalhousie.university.novahousing.services.bookViewing;

import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;
import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.model.screenRenters.UserDetails;
import com.dalhousie.university.novahousing.repository.bookViewing.BookViewingRepository;
import com.dalhousie.university.novahousing.services.screening.PropertyCheckService;
import com.dalhousie.university.novahousing.services.screening.ScreeningService;
import com.dalhousie.university.novahousing.services.screening.ViewingApplicationScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookViewingServiceImpl implements BookViewingService{

    @Autowired
    BookViewingRepository bookViewingRepositoryImp;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PropertyCheckService propertyCheckService;

    @Autowired
    ScreeningService screeningService=new ViewingApplicationScreeningService();

    @Override
    public List<BookViewing> getAllViewingApplications() {
        return bookViewingRepositoryImp.getAllViewings();
    }

    @Override
    public BookViewing getViewingApplicationByBookingID(long bookingID) {
        return bookViewingRepositoryImp.GetViewingDetailsBookingID(bookingID);
    }
    public List<BookViewing> getViewingApplicationsByPropertyID(String propertyID){

        return bookViewingRepositoryImp.GetViewingDetailsPropertyID(propertyID);
    }

    @Override
    public List<BookViewing> RecommendedViewingApplication(String propertyID) {

        List<BookViewing> RecommendedViewingApplications =new ArrayList<>();

        List<BookViewing> viewing_applications= getViewingApplicationsByPropertyID(propertyID);
        for (BookViewing viewing_application : viewing_applications) {

            UserDetails userDetails= userDetailsService.getDetails(viewing_application.getUsername());
            PropertyChecks propertyChecks=propertyCheckService.getPropertyChecks(propertyID);

            if(screeningService.Screening(userDetails,propertyChecks)){
                RecommendedViewingApplications.add(viewing_application);}
        }
        return RecommendedViewingApplications;
    }

    @Override
    public void newViewingApplication(BookViewing NewViewing) {
        BookViewing bookViewing=new BookViewing(NewViewing.getBookingID(),NewViewing.getPropertyID(),NewViewing.getVisitDate(),NewViewing.isConformationStatus(),NewViewing.getUsername());
        bookViewingRepositoryImp.createViewing(bookViewing);
     }

    @Override
    public void approveViewingApplication(long bookingID) {
        bookViewingRepositoryImp.approveViewing(bookingID);
    }

    @Override
    public void deleteViewingApplicationByID(long booking_ID) {

    }


}
