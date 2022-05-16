//Author: Sidharth
package com.dalhousie.university.novahousing.repository.bookViewing;

import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;

import java.util.List;

public interface BookViewingRepository{
    void createViewing(BookViewing bookViewing);
    BookViewing GetViewingDetailsBookingID(long bookingID);
    void approveViewing(long bookingID);
    List<BookViewing> GetViewingDetailsPropertyID(String propertyID);
    List<BookViewing> getAllViewings();
}
