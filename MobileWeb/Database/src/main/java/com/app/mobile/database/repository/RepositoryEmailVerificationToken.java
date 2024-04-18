package com.app.mobile.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mobile.model.EmailVerification;


public interface RepositoryEmailVerificationToken extends JpaRepository<EmailVerification, Long> {

}
