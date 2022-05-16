//Author: Sidharth
package com.dalhousie.university.novahousing.services.bookViewing;

import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;

import java.util.List;

public interface BookViewingService{

    List<BookViewing> getAllViewingApplications();
    BookViewing getViewingApplicationByBookingID(long bookingID);
    List<BookViewing> getViewingApplicationsByPropertyID(String propertyID);
    List<BookViewing> RecommendedViewingApplication(String propertyID);
    void newViewingApplication(BookViewing NewViewing);
    void approveViewingApplication(long bookingID);
    void deleteViewingApplicationByID(long booking_ID);
}
