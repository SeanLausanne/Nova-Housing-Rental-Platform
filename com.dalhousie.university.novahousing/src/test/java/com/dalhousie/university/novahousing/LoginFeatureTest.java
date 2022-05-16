package com.dalhousie.university.novahousing;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.validations.loginValidation.LoginValidation;
import com.dalhousie.university.novahousing.validations.loginValidation.LoginValidationImpl;
import com.dalhousie.university.novahousing.exception.LoginException;
import com.dalhousie.university.novahousing.model.login.Login;
import com.dalhousie.university.novahousing.model.login.LoginUser;
import com.dalhousie.university.novahousing.repository.login.LoginRepository;
import com.dalhousie.university.novahousing.services.login.LoginService;
import com.dalhousie.university.novahousing.utils.AESEncryption;
import com.dalhousie.university.novahousing.utils.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class LoginFeatureTest {

    Login loginTestUser;
    LoginUser loginUserDetails;

    @MockBean
    LoginRepository loginRepositoryMock;

    @Autowired
    LoginService loginService;

    LoginValidation loginValidator;


    @BeforeEach
    public void init() throws Exception {

        loginTestUser = new Login();
        loginTestUser.setUsername("anita.mishra2106@gmail.com");
        loginTestUser.setPassword("Sdc@1231");
        loginTestUser.setRole(Role.ROLE_USER);

        loginUserDetails=new LoginUser();
        loginUserDetails.setId(1);
        loginUserDetails.setFirstName("Anita");
        loginUserDetails.setLastName("Vidant");
        loginUserDetails.setUsername("anita.mishra2106@gmail.com");
        loginUserDetails.setPhone_number("+1 902-442-0510");
        loginUserDetails.setRole(Role.ROLE_USER);
        loginUserDetails.setPassword(AESEncryption.encrypt("Sdc@1231"));
        loginUserDetails.setConfirm_password(AESEncryption.encrypt("Sdc@1231"));

        loginValidator=new LoginValidationImpl(loginUserDetails);
    }

    /*
     * The loginservice will throw an exception if login details are set to empty values.
     * */
    @Test
    public void testEmptyLoginUserUsernameInput() {
        loginTestUser.setUsername("");
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        LoginException exception = assertThrows(LoginException.class, () -> loginService.authenticateUser(loginTestUser));
        assertEquals("Username is mandatory", exception.getMessage());
    }


    @Test
    public void testNullLoginUserUsernameInput() {
        loginTestUser.setUsername(null);
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        LoginException exception = assertThrows(LoginException.class, () -> loginService.authenticateUser(loginTestUser));
        assertEquals("Username is mandatory", exception.getMessage());
    }


    @Test
    public void testNullLoginUserPasswordInput() {
        loginTestUser.setPassword(null);
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        LoginException exception = assertThrows(LoginException.class, () -> loginService.authenticateUser(loginTestUser));
        assertEquals("Password not provided", exception.getMessage());
    }

    @Test
    public void testEmptyLoginUserPasswordInput() {
        loginTestUser.setPassword("");
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        LoginException exception = assertThrows(LoginException.class, () -> loginService.authenticateUser(loginTestUser));
        assertEquals("Password not provided", exception.getMessage());
    }

    @Test
    public void validateIncorrectPassword(){
        loginTestUser.setUsername("anita.mishra2106@gmail.com");
        loginTestUser.setPassword("123675");
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        LoginException exception = assertThrows(LoginException.class, () -> loginValidator.validatePasswordInputs(loginTestUser.getPassword()));
        assertEquals("Password did not match", exception.getMessage());
    }


    /*//** The test case will pass when login details exists in database. This is a positive scenario
     * */
    @Test
    public void loginValidateUserExistence() throws Exception {
        loginTestUser.setUsername("anita.mishra2106@gmail.com");
        loginTestUser.setPassword("Sdc@1231");
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        assertTrue(loginService.authenticateUser(loginTestUser));
    }


    @Test
    public void validateCorrectPassword() throws Exception {
        loginTestUser.setPassword("Sdc@1231");
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        assertTrue(loginService.authenticateUser(loginTestUser));
    }


    @Test
    public void login() throws Exception {
        loginTestUser.setUsername("anita.mishra2106@gmail.com");
        loginTestUser.setPassword("Sdc@1231");
        Mockito.when(loginRepositoryMock.getUserByUsername(loginTestUser.getUsername())).thenReturn(loginUserDetails);
        assertTrue(loginService.authenticateUser(loginTestUser));
    }
}