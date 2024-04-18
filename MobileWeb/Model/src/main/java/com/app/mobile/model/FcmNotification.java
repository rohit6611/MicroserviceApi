package com.app.mobile.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FcmNotification {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String message;
	private String title; // Title of the notification

	private String sender; // Sender of the notification (if applicable)

	private String notificationType; // email / notification /sms / call

	private String actionUrl; // URL to redirect the recipient when they interact with the notification

}
