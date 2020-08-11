package com.goshop.report.Controller;

import com.goshop.report.dto.MailDto;
import com.goshop.report.service.mailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/email")
public class SMTPController {

    @Autowired
    mailSenderService mailSenderService;

    @PostMapping("/text")
    public ResponseEntity sendEamil(@Valid @RequestBody MailDto mailDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else
            mailSenderService.sendEmail(mailDto.getToEmail(), mailDto.getSubject(), mailDto.getBody());

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
