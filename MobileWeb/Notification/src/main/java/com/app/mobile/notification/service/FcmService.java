package com.app.mobile.notification.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FcmService {

    @Value("${app.firebase-server-key}")
    private String firebaseServerKey;

    public String  sendNotification(String token, String title, String message, String customDataKey, String customDataValue) {
      
    	
    	Notification notification = Notification.builder()
    	        .setTitle("Notification Title")
    	        .setBody("Notification Body")
    	        .setImage("https://example.com/image.jpg")
    	        .build();
    	
    	Message fcmMessage = Message.builder()
                .setNotification(notification)
                .putData(customDataKey, customDataValue) // Add custom data to the data payload
                .setToken(token)
                .build();

        try {
          return  FirebaseMessaging.getInstance().send(fcmMessage, true); // Set dryRun to true for testing purposes
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
}

