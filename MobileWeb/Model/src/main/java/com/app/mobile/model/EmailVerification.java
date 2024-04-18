package com.app.mobile.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`EmailVerification`")
@Data
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String verificationToken;

    private LocalDateTime expiryDateTime;

    private LocalDateTime verifiedDateTime; // Field to store the verification timestamp

    private LocalDateTime createdDateTime; // Field to store the creation timestamp

    private String platform; // Field to store the platform from which the verification was requested

    private String requestedBy; // Field to store the entity/user who requested the verification

    private boolean verified;
    
    private String AppPackage;

}

