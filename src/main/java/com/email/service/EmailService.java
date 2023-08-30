package com.email.service;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author im_na
 */
@Service
public class EmailService {

    public boolean sendEmail(String sub, String message, String to) {
        // variable for emil
        boolean flag = false;
        String host = "smtp.gmail.com";
        String from = "akibquazi345@gmail.com";
        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("properties".toUpperCase() + properties);

        // setting important information to properties object
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");

        // step:1 to get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("akibquazi345@gmail.com", "nawaz01@01");
            }
        });

        session.setDebug(true);

        // step :2 compose the message [text , multi media]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            //from email
            mimeMessage.setFrom(from);

            // adding recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // adding subject to message
            mimeMessage.setSubject(sub);

            // adding text to message
            mimeMessage.setText(message);

            // step :3 send the message using transport class
            Transport.send(mimeMessage);

            System.out.println("send success full ");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return flag;
    }

}

