package com.app.mobile.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mobile.model.EmailVerification;
import com.app.mobile.model.FcmToken;

public interface RepositoryFcm extends JpaRepository<FcmToken, Long> {
	
	
	
	
	

}
