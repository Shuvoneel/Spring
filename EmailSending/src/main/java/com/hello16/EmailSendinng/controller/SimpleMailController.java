package com.hello16.EmailSendinng.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.hello16.EmailSendinng.entity.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleMailController {
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/send")     // Mail without Attached Document
    public String sendMail() {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        SendMail mail = new SendMail();

        try {
            helper.setTo("mhshuvo29@yahoo.com");
            helper.setText("Greetings from Shuvo:)");
            helper.setSubject("Shuvo");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }

    @RequestMapping("/sendAt")        // // Mail with Attached Document
    public String sendMailAttachment() throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        try {
            helper.setTo("mhshuvo29@yahoo.com");
            helper.setText("Greetings :)\n Please find the attached document for your reference.");
            helper.setSubject("Mail From Shuvo");
            ClassPathResource file = new ClassPathResource("document.PNG");
            helper.addAttachment("document.PNG", file);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }

}
