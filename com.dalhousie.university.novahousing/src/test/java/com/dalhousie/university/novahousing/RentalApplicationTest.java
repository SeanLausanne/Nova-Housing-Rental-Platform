package com.dalhousie.university.novahousing;

import com.dalhousie.university.novahousing.model.bookViewing.RentalApplication;
import com.dalhousie.university.novahousing.repository.screeningRentalApplication.RentalApplicationRepository;
import com.dalhousie.university.novahousing.services.screening.RentalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RentalApplicationTest {

    RentalApplication rentalApplication;


    @MockBean
    RentalApplicationRepository rentalApplicationRepositoryMock;

    @Autowired
    RentalService rentalService;

    @BeforeEach
    public void init() throws Exception{
        //  MockitoAnnotations.openMocks(bookViewingTest);
        rentalApplication=new RentalApplication();
        rentalApplication.setApplier_username("test");
        rentalApplication.setOccupants("value");}

    @Test
    public void rentalTest(){
        assertEquals("test",rentalApplication.getApplier_username());
    }

    @Test
    public void rentalOccupantTest(){
        assertEquals("value",rentalApplication.getOccupants());
    }


}


