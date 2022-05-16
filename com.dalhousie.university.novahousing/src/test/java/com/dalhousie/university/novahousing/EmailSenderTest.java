package com.dalhousie.university.novahousing;

import com.dalhousie.university.novahousing.services.email.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailSenderService emailSenderService;

    @Test
    public void testEmail(){
        emailSenderService.sendSimpleEmail("rutujo1@gmail.com","EMAIL FEATURE TEST!","Test Email");
    }
}
