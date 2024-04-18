package com.app.mobile.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.mobile.model.MobileVerification;

public interface RepositoryMobileNoVerification extends JpaRepository<MobileVerification, Long> {

}
