//Author: Rutu Sadaykumar Joshi

package com.dalhousie.university.novahousing.services.email;

public interface EmailSenderService {
    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject);
}
