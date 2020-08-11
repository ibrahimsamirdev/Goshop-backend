package com.goshop.report.service;

import javax.mail.MessagingException;
import java.io.IOException;

public interface mailSenderService {

    void sendEmail(String toEmail,String subject,String text);
   void sendEmailWithAttachment(String toEmail,String subject,String Type) throws MessagingException, IOException;
}
