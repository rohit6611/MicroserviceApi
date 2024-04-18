package com.app.mobile.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mobile.database.repository.RepositoryNotification;
import com.app.mobile.model.Notification;

@Service
public class NotificationService {

    private final RepositoryNotification notificationRepository;

    @Autowired
    public NotificationService(RepositoryNotification notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }


    public void sendNotification(Notification notification) {
    	
    	
    	
    	if(notification.getType()==1)
    	{
    		new FcmService().sendNotification(null, null, null, null, null);
    	}else  if(notification.getType()==2)
    	{

    		//email
    		
    	} else if(notification.getType()==3)
    	{

    	// sms 
    	
    	}
    
    }
}

