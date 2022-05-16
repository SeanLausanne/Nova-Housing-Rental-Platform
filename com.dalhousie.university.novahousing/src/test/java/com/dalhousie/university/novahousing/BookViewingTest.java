package com.dalhousie.university.novahousing;



import com.dalhousie.university.novahousing.exception.ApplyException;
import com.dalhousie.university.novahousing.model.bookViewing.BookViewing;
import com.dalhousie.university.novahousing.repository.bookViewing.BookViewingRepository;
import com.dalhousie.university.novahousing.services.bookViewing.BookViewingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

//import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class BookViewingTest {

    BookViewing bookViewingTest;

    @MockBean
    BookViewingRepository bookViewingRepositoryMock;

    @Autowired
    BookViewingService bookViewingService;

    @BeforeEach
    public void init() throws Exception{
      //  MockitoAnnotations.openMocks(bookViewingTest);
        bookViewingTest=new BookViewing();
        bookViewingTest.setUsername("sid");
        bookViewingTest.setPropertyID("123");
        bookViewingTest.setConformationStatus(true);
    }

    @Test
    public void testUsername() throws ApplyException {
       BookViewing bookViewing=mock(BookViewing.class);
       Mockito.doNothing().when(bookViewing).setUsername(anyString());
       bookViewing.setUsername("hello");
       verify(bookViewing,times(1)).setUsername("hello");
 }

    @Test
    public void testBookingID() throws ApplyException {
        bookViewingTest.setBookingID(1234);
        assertEquals(1234,bookViewingTest.getBookingID());
      }

    @Test
    public void testConfirmationStatus() throws ApplyException {
        bookViewingTest.setConformationStatus(false);
        assertFalse(bookViewingTest.isConformationStatus());
    }

    @Test
    public void testPropertyID() throws ApplyException {
        bookViewingTest.setPropertyID("776");
        assertEquals("776",bookViewingTest.getPropertyID());
    }


//    @Test
//    public void testUsernameRepository() throws ApplyException {
//        BookViewingRepository bookViewingRepositoryMock=mock(BookViewingRepositoryImp.class);
//      //  Mockito.doThrow().when(bookViewingRepositoryMock).createViewing();
//        bookViewingTest=new BookViewing();
//        bookViewingTest.setUsername("X");
//        Mockito.doNothing().when(bookViewingRepositoryMock).createViewing(bookViewingTest);
//        bookViewingRepositoryMock.createViewing(bookViewingTest);
//        verify(bookViewingRepositoryMock,times(1)).createViewing(bookViewingTest);
//    }
}
