package com.app.mobile.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobile.model.EmailVerification;
import com.app.mobile.model.MobileVerification;
import com.app.mobile.notification.service.EmailVerificationService;
import com.app.mobile.notification.service.MobileNoVerificationService;



@RestController
@RequestMapping("/verification")
public class VerificationController {

    private final EmailVerificationService emailVerificationService;
    private final MobileNoVerificationService mobileVerificationService;

    @Autowired
    public VerificationController(EmailVerificationService emailVerificationService, MobileNoVerificationService mobileVerificationService) {
        this.emailVerificationService = emailVerificationService;
        this.mobileVerificationService = mobileVerificationService;
    }

    @PostMapping("/email")
    public EmailVerification sendEmailVerification(@RequestBody String email) {
        return emailVerificationService.sendVerificationEmail(email);
    }

    @PostMapping("/mobile")
    public MobileVerification sendMobileVerification(@RequestBody String mobileNumber) {
        return mobileVerificationService.createMobileVerification(mobileNumber);
    }
}

