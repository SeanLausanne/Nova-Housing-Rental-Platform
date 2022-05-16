package com.dalhousie.university.novahousing;

import com.dalhousie.university.novahousing.model.rentApplication.RentApplication;
import com.dalhousie.university.novahousing.repository.rentApplication.RentApplicationRepositoryImpl;
import com.dalhousie.university.novahousing.services.applyRent.ApplyRentService;
import com.dalhousie.university.novahousing.exception.ApplyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ApplyFeatureTest<rentApplication> {
    RentApplication rentApplicationTest;

    @MockBean
    RentApplicationRepositoryImpl applicationRepositoryMock;

    @Autowired
    ApplyRentService applyRent;


    @BeforeEach
    public void init() throws Exception {
        rentApplicationTest = new RentApplication();
        rentApplicationTest.setApplier_username("rutu");
        String stringDate ="2021-12-30";
        Date date1= Date.valueOf(stringDate);
        rentApplicationTest.setMoveInDate(date1);
        rentApplicationTest.setPhone_number("+1 123-456-7890");
        rentApplicationTest.setAnimal("yes");
        rentApplicationTest.setAnnualsalary(1000);
        rentApplicationTest.setOccupants("anita");
    }

    //testing username = ""
    @Test
    public void testEmptyUserName() {
        rentApplicationTest.setApplier_username("");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please provide a name.",exception.getMessage());
    }


    //testing username = null
    @Test
    public void testNullUsername(){
        rentApplicationTest.setApplier_username(null);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please provide a name.",exception.getMessage());
    }

    //testing username = "rutu"
    @Test
    public void testValidUsername() throws ApplyException {
        rentApplicationTest.setApplier_username("rutu");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }

    //testing moveindate = "2021-12-01"
    @Test
    public void testInvalidDate() throws ApplyException, ParseException {
        String stringDate = "2021-12-01";
        Date invalidDate = Date.valueOf(stringDate);
        rentApplicationTest.setMoveInDate(invalidDate);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please provide valid move in date.",exception.getMessage());
    }

    //testing moveindate = null
    @Test
    public void testNullDate() throws ParseException {
        //String stringDate = "";
        Date date = null;
        rentApplicationTest.setMoveInDate(date);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please provide valid move in date.",exception.getMessage());
    }

    //testing moveindate = 2021-12-30
    @Test
    public void testValidDate() throws ParseException, ApplyException {
        String stringDate = "2021-12-30";
        Date validDate = Date.valueOf(stringDate);
        rentApplicationTest.setMoveInDate(validDate);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }

    //testing phonenumber = null
    @Test
    public void testNullPhonenumber() {
        rentApplicationTest.setPhone_number(null);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter phone number.",exception.getMessage());
    }

   //testing phonenumber = ""
    @Test
    public void testEmptyPhonenumber() {
        rentApplicationTest.setPhone_number("");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter phone number.",exception.getMessage());
    }

    //testing phonenumber = "1234567890"
    @Test
    public void testInvalidPhonenumberWithoutCountryCode() {
        rentApplicationTest.setPhone_number("1234567890");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid phone number.",exception.getMessage());
    }

    //testing phonenumber = "+11234567890"
    @Test
    public void testInvalidPhonenumberWithCountryCode() {
        rentApplicationTest.setPhone_number("+11234567890");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid phone number.",exception.getMessage());
    }

    //testing phonenumber = "+1 1234567890"
    @Test
    public void testPhonenumberWithInvalidFormat() {
        rentApplicationTest.setPhone_number("+1 1234567890");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid phone number.",exception.getMessage());
    }
   
    //testing phonenumber = "+1 123-456-7890"
    @Test
    public void testPhonenumberWithValidFormat() throws ApplyException {
        rentApplicationTest.setPhone_number("+1 123-456-7890");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        //ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing phonenumber = "+1 123-456-1"
    @Test
    public void testPhonenumberWithLessDigits() throws ApplyException {
        rentApplicationTest.setPhone_number("+1 123-456-1");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid phone number.",exception.getMessage());
    }

    //testing animal = "yes"
    @Test
    public void testValidAnimalInputYES() throws ApplyException {
        rentApplicationTest.setAnimal("yes");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));

    }
    
    //testing animal = "no"
    @Test
    public void testInvalidAnimalInputNO() throws ApplyException {
        rentApplicationTest.setAnimal("no");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));

    }
    
    //testing animal = ""
    @Test
    public void testInvalidAnimalInputEMPTY() {
        rentApplicationTest.setAnimal("");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid input.",exception.getMessage());
    }

    //testing animal = "dog"
    @Test
    public void testInvalidAnimalInputANIMALTYPE() {
        rentApplicationTest.setAnimal("dog");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid input.",exception.getMessage());
    }
   
    //testing animal = "YES"
    @Test
    public void testValidAnimalInputCaseSensitiveYES() throws ApplyException {
        rentApplicationTest.setAnimal("YES");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing animal = "NO"
    @Test
    public void testValidAnimalInputCaseSensitiveNO() throws ApplyException {
        rentApplicationTest.setAnimal("NO");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing animal = "Yes"
    @Test
    public void testValidAnimalInputCaseSensitiveYes() throws ApplyException {
        rentApplicationTest.setAnimal("Yes");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing animal = "No"
    @Test
    public void testValidAnimalInputCaseSensitiveNo() throws ApplyException {
        rentApplicationTest.setAnimal("No");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing animal = "yEs"
    @Test
    public void testValidAnimalInputCaseSensitiveyEs() throws ApplyException {
        rentApplicationTest.setAnimal("yEs");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing animal = "yeS"
    @Test
    public void testValidAnimalInputCaseSensitiveyeS() throws ApplyException {
        rentApplicationTest.setAnimal("yeS");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing annualsalary = 1000
    @Test
    public void testValidAnnualSalary() throws ApplyException {
        rentApplicationTest.setAnnualsalary(1000);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
    
    //testing annualsalary = 0;
    @Test
    public void testInvalidAnnualSalary() throws ApplyException {
        rentApplicationTest.setAnnualsalary(0);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please enter valid annualSalary.",exception.getMessage());
    }
    
    //testing annualsalary = 500
    @Test
    public void testInvalidAnnualSalaryLessThan1000() throws ApplyException {
        rentApplicationTest.setAnnualsalary(500);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Minimum annual salary should be more then 1000.",exception.getMessage());
    }

    //testing occupants = null
    @Test
    public void testNullOccupants(){
        rentApplicationTest.setOccupants(null);
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please provide occupants' name.",exception.getMessage());
    }
   
    //testing occupants = ""
    @Test
    public void testEmptyOccupants(){
        rentApplicationTest.setOccupants("");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        ApplyException exception = assertThrows(ApplyException.class, () -> applyRent.applyRent(rentApplicationTest));
        assertEquals("Please provide occupants' name.",exception.getMessage());
    }
    
    //testing occupants = "anita"
    @Test
    public void testValidOccupants() throws ApplyException {
        rentApplicationTest.setOccupants("anita");
        Mockito.when(applicationRepositoryMock.applyRent(rentApplicationTest)).thenReturn(1L);
        assertEquals(true, applyRent.applyRent(rentApplicationTest));
    }
}
