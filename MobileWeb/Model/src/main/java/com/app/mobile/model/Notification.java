package com.app.mobile.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private LocalDateTime timestamp;

	private boolean isRead; // Indicates whether the notification has been read by the recipient

	private String status; // Status of the notification (e.g., pending, sent, failed)

	private String AppPackage;
    private Integer    Type;


	// Additional parameters as needed...

	// Constructors, getters, and setters
    @OneToOne(cascade = CascadeType.ALL)
	private Email mEmail;
    
    @OneToOne(cascade = CascadeType.ALL)
	private SMS mSms;

    @OneToOne(cascade = CascadeType.ALL)
    private FcmNotification mFcmNotification;

}
