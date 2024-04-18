package com.app.mobile.notification.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.mobile.database.repository.RepositoryEmailVerificationToken;
import com.app.mobile.database.repository.RepositorySession;
import com.app.mobile.model.EmailVerification;

@Service
public class EmailVerificationService {

    private final JavaMailSender javaMailSender;
    private final RepositoryEmailVerificationToken tokenRepository;

    @Autowired
    public EmailVerificationService(JavaMailSender javaMailSender, RepositoryEmailVerificationToken tokenRepository) {
        this.javaMailSender = javaMailSender;
        this.tokenRepository = tokenRepository;
    }

    public EmailVerification sendVerificationEmail(String email)  {
    	
    	try {
    		
        String token = generateToken();
        // Save the token to the database
        EmailVerification verificationToken = new EmailVerification();
        verificationToken.setEmail(email);
        verificationToken.setVerificationToken(token);
        verificationToken.setVerified(false);
        tokenRepository.save(verificationToken);
        
        // Prepare and send the verification email
        String verificationLink = "https://yourwebsite.com/verify-email?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Email Verification");
        message.setText("Please click on the following link to verify your email: " + verificationLink);
        javaMailSender.send(message);
       
        return verificationToken;
    	
        
        }catch(Exception e)
    	{
    		
    		e.printStackTrace();
    	}
		return null;
    	
    	
    }

    private String generateToken() {
        // Implement your token generation logic here
        // For simplicity, you can use UUID.randomUUID() for generating a random token
        return UUID.randomUUID().toString();
    }
}

