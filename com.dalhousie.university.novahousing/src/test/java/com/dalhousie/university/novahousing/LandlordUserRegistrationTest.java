package com.dalhousie.university.novahousing;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.model.Userfactory.model.LandlordUser;
import com.dalhousie.university.novahousing.validations.userRegistrationValidation.UserRegistrationValidation;
import com.dalhousie.university.novahousing.validations.userRegistrationValidation.UserRegistrationValidationImpl;
import com.dalhousie.university.novahousing.exception.UserRegistrationException;
import com.dalhousie.university.novahousing.repository.user.UserRepositoryImpl;

import com.dalhousie.university.novahousing.services.user.UserService;
import com.dalhousie.university.novahousing.utils.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Testing if service is working perfectly or not
@SpringBootTest
public class LandlordUserRegistrationTest {

    LandlordUser userRegistrationTestObject;

    UserRegistrationValidation userRegistrationValidator;

    @MockBean
    UserRepositoryImpl userRepositoryMock;

    @Autowired
    UserService userService;


    @BeforeEach
    public void init() {
        userRegistrationTestObject =new LandlordUser();
        userRegistrationValidator=new UserRegistrationValidationImpl();
        userRegistrationTestObject.setId(1);
        userRegistrationTestObject.setFirstName("Anita");
        userRegistrationTestObject.setLastName("Vidant");
        userRegistrationTestObject.setUsername("anita.mishra2106@gmail.com");
        userRegistrationTestObject.setPhone_number("+1 902-442-0510");
        userRegistrationTestObject.setRole(Role.ROLE_LANDLORD);
        userRegistrationTestObject.setPassword("Sdc@1231");
        userRegistrationTestObject.setConfirm_password("Sdc@1231");
    }


    /*
     *Covering firstName test cases
     *Negative and Positive scenario
     */
    // Null Test case for firstname - negative test case scenario
    @Test
    public void testNullFirstnameInput(){
        userRegistrationTestObject.setFirstName(null);
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Firstname is required", exception.getMessage());
    }

    // Test case when user does not enter firstname - negative test case scenario
    @Test
    public void testEmptyFirstnameInput(){
        userRegistrationTestObject.setFirstName("");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Firstname is required", exception.getMessage());
    }


    // Test case when user enters firstname- positive test case scenario
    @Test
    public void testFilledFirstnameInput() throws Exception{
        userRegistrationTestObject.setFirstName("Anita");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }


    /*
     *Covering lastName test cases
     *Negative and Positive scenario
     */
    // Null Test case for lastname - negative test case scenario
    @Test
    public void testNullLastnameInput(){
        userRegistrationTestObject.setLastName(null);
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Lastname is required", exception.getMessage());
    }

    // Test case when user does not enter lastname - negative test case scenario
    @Test
    public void testEmptyLastnameInput(){
        userRegistrationTestObject.setLastName("");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Lastname is required", exception.getMessage());
    }

    // Test case when user enters lastname- positive test case scenario
    @Test
    public void testFilledLastnameInput() throws Exception {
        userRegistrationTestObject.setFirstName("Anita");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
        //UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateFirstName(userRegistrationTestObject.getFirstName()));
    }


    /*
     *Covering Password test cases
     *Negative and Positive scenario
     */
    // Null Test case for password - negative test case scenario
    @Test
    public void testNullPasswordInput(){
        userRegistrationTestObject.setPassword(null);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validatePassword(userRegistrationTestObject.getPassword()));
        assertEquals("Password is required", exception.getMessage());
    }


    // Test case when user does not enter password - negative test case scenario
    @Test
    public void testEmptyPasswordInput(){
        userRegistrationTestObject.setPassword("");
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validatePassword(userRegistrationTestObject.getPassword()));
        assertEquals("Password is required", exception.getMessage());
    }


    // Test case when user enters password without following pattern set by the application- negative test case scenario
    @Test
    public void testFilledPasswordInputWithIncorrectPattern(){
        userRegistrationTestObject.setPassword("123456");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Password should be of minimum length 8 and must contain atleast a special character,a number, a uppercase letter and a smallcase letter", exception.getMessage());
    }


    // Test case when user enters correct password by following pattern set by the application- positive test case scenario
    @Test
    public void testFilledPasswordInputWithCorrectPattern() throws Exception {
        userRegistrationTestObject.setPassword("Sdc@1231");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }

    /*
     *Covering Confirm Password test cases
     *Negative and Positive scenario
     */
    // NUll Test case for confirm password - negative test case scenario
    @Test
    public void testNullConfirmPasswordInput(){
        userRegistrationTestObject.setConfirm_password(null);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateConfirmPassword(userRegistrationTestObject.getConfirm_password()));
        assertEquals("Confirm Password is required", exception.getMessage());
    }

    // Test case when user does not enter confirm password - negative test case scenario
    @Test
    public void testEmptyConfirmPasswordInput(){
        userRegistrationTestObject.setConfirm_password("");
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateConfirmPassword(userRegistrationTestObject.getConfirm_password()));
        assertEquals("Confirm Password is required", exception.getMessage());
    }

    // Test case when user enters confirm password without following pattern set by the application- negative test case scenario
    @Test
    public void testFilledConfirmPasswordInputWithIncorrectPattern(){
        userRegistrationTestObject.setConfirm_password("123456");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Confirm Password should be of minimum length 8 and must contain atleast a special character,a number, a uppercase letter and a smallcase letter", exception.getMessage());
    }


    // Test case when user enters correct confirm password by following pattern set by the application- positive test case scenario
    @Test
    public void testFilledConfirmPasswordInputWithCorrectPattern() throws Exception {
        userRegistrationTestObject.setPassword("Sdc@1231");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }


    // Test case when user enters different password and confirm password- negative test case scenario
    @Test
    public void testUnEqualedPasswordConfirmPassword(){
        userRegistrationTestObject.setPassword("Sdc@1231");
        userRegistrationTestObject.setConfirm_password("Sdc@12312");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userService.registerUser(userRegistrationTestObject));
        assertEquals("Confirm Password and Password did not match", exception.getMessage());

    }

    // Test case when password and confirm password are same- positive test case scenario
    @Test
    public void testEqualedPasswordConfirmPassword() throws Exception {
        userRegistrationTestObject.setPassword("Sdc@1231");
        userRegistrationTestObject.setConfirm_password("Sdc@1231");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }


    /*
     *Covering Phone Number test cases
     *Negative and Positive scenario
     */
    // Null Test case for phone Number - negative test case scenario
    @Test
    public void testNullPhoneNumberInput(){
        userRegistrationTestObject.setPhone_number(null);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validatePhoneNumber(userRegistrationTestObject.getPhone_number()));
        assertEquals("Phone number is required", exception.getMessage());
    }

    // Test case when user does not enter confirm password - negative test case scenario
    @Test
    public void testEmptyPhoneNumberInput(){
        userRegistrationTestObject.setPhone_number("");
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validatePhoneNumber(userRegistrationTestObject.getPhone_number()));
        assertEquals("Phone number is required", exception.getMessage());
    }

    // Test case when user enters phone number- positive test case scenario
    @Test
    public void testFilledPhoneNumber() throws Exception {
        userRegistrationTestObject.setPhone_number("+1 902-442-0510");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }

    // Test case when user enters phone number- positive test case scenario
    @Test
    public void testInCorrectPhoneNumberPattern(){
        userRegistrationTestObject.setPhone_number("98657");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validatePhoneNumber(userRegistrationTestObject.getPassword()));
        assertEquals("Invalid Phone number", exception.getMessage());
    }

    // Test case when user enters phone number- positive test case scenario
    @Test
    public void testCorrectPhoneNumberPattern() throws Exception {
        userRegistrationTestObject.setPhone_number("+1 902-442-0510");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }

    // Test case when user selects user role- positive test case scenario
    @Test
    public void testFilledUserRole() throws Exception {
        userRegistrationTestObject.setRole(Role.ROLE_USER);
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }

    // Test case when user tries to enter incorrect user role- negative test case scenario
    @Test
    public void testIncorrectUserRole(){
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateUserRole("ROLE_RANDOM"));
        assertEquals("Not a valid user role", exception.getMessage());
    }


    /*
     *Covering Username test cases
     *Negative and Positive scenario
     */
    // Null Test case for username - negative test case scenario
    @Test
    public void testNullUsernameInput(){
        userRegistrationTestObject.setUsername(null);
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateUsername(userRegistrationTestObject.getUsername()));
        assertEquals("Username is mandatory", exception.getMessage());
    }


    // Test case when user does not enter username - negative test case scenario
    @Test
    public void testEmptyUsernameInput(){
        userRegistrationTestObject.setUsername("");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateUsername(userRegistrationTestObject.getUsername()));
        assertEquals("Username is mandatory", exception.getMessage());
    }

    // Test case when user enters and correct username- positive test case scenario
    @Test
    public void testFilledUsernameWithPattern() throws Exception {
        userRegistrationTestObject.setUsername("anita@gmail.com");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        assertEquals(1,userService.registerUser(userRegistrationTestObject));
    }

    // Test case when user enters phone number- positive test case scenario
    @Test
    public void testInCorrectUsernamePattern(){
        userRegistrationTestObject.setUsername("anitarsgfb.com");
        Mockito.when(userRepositoryMock.save(userRegistrationTestObject)).thenReturn(1L);
        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> userRegistrationValidator.validateUsername(userRegistrationTestObject.getUsername()));
        assertEquals("Pleas enter valid username", exception.getMessage());
    }
}
