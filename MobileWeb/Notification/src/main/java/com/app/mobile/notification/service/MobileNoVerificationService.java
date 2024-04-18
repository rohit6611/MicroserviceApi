package com.app.mobile.notification.service;

import com.app.mobile.database.repository.RepositoryMobileNoVerification;
import com.app.mobile.model.MobileVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MobileNoVerificationService {

	@Autowired
	private RepositoryMobileNoVerification mobileVerificationRepository;

	@Autowired
	MobileService mobileService;

	public MobileVerification createMobileVerification(String mobileNumber) {
		// Generate a random 6-digit verification code
		String verificationCode = generateVerificationCode();

		// Set expiry time (e.g., 5 minutes from now)
		LocalDateTime expiryDateTime = LocalDateTime.now().plusMinutes(5);

		// Create a MobileVerification object and save it to the database
		MobileVerification mobileVerification = new MobileVerification();
		mobileVerification.setMobileNumber(mobileNumber);
		mobileVerification.setVerificationCode(verificationCode);
		mobileVerification.setExpiryDateTime(expiryDateTime);
		mobileVerification.setVerified(false);

		String message = "Your verification code is: " + verificationCode;

		mobileService.sendVerificationSMS(mobileNumber, message);

		return mobileVerificationRepository.save(mobileVerification);
	}

	private String generateVerificationCode() {
		Random random = new Random();
		int min = 100000;
		int max = 999999;
		return String.valueOf(random.nextInt(max - min + 1) + min);
	}

}
