package com.email.Controllr;

import com.email.Model.EmailRequest;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author im_na
 */
@RestController
public class EmailController {
    @Autowired
    EmailService service;

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
        System.out.println(request);

        boolean result=this.service.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
        if (result) {
            return ResponseEntity.ok("Done");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not sent");
        }
    }
}
