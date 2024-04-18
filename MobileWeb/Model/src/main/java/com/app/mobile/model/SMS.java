package com.app.mobile.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class SMS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String MobileNo; 
	private String CountryCode;
	private String Status;
	
	@Column(length = 1000) // Adjust length as per your requirement
	private String Response; // response as a string

}
