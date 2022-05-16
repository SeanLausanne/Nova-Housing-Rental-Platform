package com.dalhousie.university.novahousing;

import com.dalhousie.university.novahousing.model.screenRenters.PropertyChecks;
import com.dalhousie.university.novahousing.repository.screeningRentalApplication.PropertyCheckRepository;
import com.dalhousie.university.novahousing.services.screening.PropertyCheckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PropertyChecksTest {

    PropertyChecks propertyChecks;

    @MockBean
    PropertyCheckRepository propertyCheckRepositoryMock;

    @Autowired
    PropertyCheckService propertyCheckService;

    @BeforeEach
    public void init() throws Exception{
        //  MockitoAnnotations.openMocks(bookViewingTest);
        propertyChecks=new PropertyChecks();
        propertyChecks.setPropertyID("1234");
        propertyChecks.setMinAnnualIncome(1000);
        propertyChecks.setMinCreditScore(600);
        propertyChecks.setRent(9000);
        propertyChecks.setPreferredRentalHistory(false);
        propertyChecks.setPreferredTenantStatus("EMPLOYEE");
    }

    @Test
    public void propertyTest(){
        assertEquals("1234",propertyChecks.getPropertyID());
    }
    @Test
    public void propertyrentTest(){
        assertEquals(9000,propertyChecks.getRent());
    }
    @Test
    public void setMinCreditScoreTest(){
        assertEquals(600,propertyChecks.getMinCreditScore());
    }
    @Test
    public void setMinAnnualIncomeTest(){
        assertEquals(1000,propertyChecks.getMinAnnualIncome());
    }
    @Test
    public void setPreferredRentalHistoryTest(){
        assertEquals("EMPLOYEE",propertyChecks.getPreferredTenantStatus());
    }

}
