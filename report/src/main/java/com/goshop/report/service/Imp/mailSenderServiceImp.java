package com.goshop.report.service.Imp;

import com.goshop.report.service.mailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class mailSenderServiceImp implements mailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toEmail,String subject,String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject(subject);
        msg.setText(text);

        javaMailSender.send(msg);
    }

    @Override
    public void sendEmailWithAttachment(String toEmail,String subject) throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);

        helper.setText("<h1>Check attachment for PDF!</h1>", true);

        helper.addAttachment("Employee_report.pdf", new ClassPathResource("Employee_report.pdf"));

        javaMailSender.send(msg);



    }
}
