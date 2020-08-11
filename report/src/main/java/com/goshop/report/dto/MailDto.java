package com.goshop.report.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class MailDto {

    @Email
    @NotNull(message = "email cannot be null")
    private String toEmail;
    @NotNull(message = "subject cannot be null")
    private String subject;
    private String body;

    public MailDto(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
