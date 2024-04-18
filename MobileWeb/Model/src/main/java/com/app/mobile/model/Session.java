package com.app.mobile.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import java.security.SecureRandom;
import java.math.BigInteger;

@Entity
@Table(name = "`session`")
@Data
public class Session {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer    Id;
	Integer    UserId;
	@Lob 
	@Column(name="CONTENT", length=5000)
	String     Token;
	String     AppPackageName;
	String     DeviceId;
	Date       TimeStamp=new Date();
	Integer    Platform;
	Date       issueDate;
	Date       expiryDate;

	
	public static String generateSessionToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[length];
        secureRandom.nextBytes(tokenBytes);
        return new BigInteger(1, tokenBytes).toString(16);
    }
	
}
