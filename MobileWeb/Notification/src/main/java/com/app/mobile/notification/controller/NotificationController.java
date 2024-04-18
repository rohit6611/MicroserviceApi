package com.app.mobile.notification.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobile.database.repository.RepositoryNotification;
import com.app.mobile.model.Notification;
import com.app.mobile.notification.service.NotificationService;





@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    
    @Autowired
    private RepositoryNotification mRepositoryNotification;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public BodyBuilder sendNotification(@RequestBody Notification notification) {
            notificationService.sendNotification(notification);
        return ResponseEntity.ok();
    }
    
    @PostMapping
    public ResponseEntity<Notification>  saveNotification(@RequestBody Notification notification) {
    	
        return ResponseEntity.ok(mRepositoryNotification.save(notification));
    }
    

//    @GetMapping("/{id}")
//    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
//        Notification notification = notificationService.getNotificationById(id);
//        return ResponseEntity.ok(notification);
//    }
//
//    @GetMapping("/recipient/{recipient}")
//    public ResponseEntity<List<Notification>> getNotificationsForRecipient(@PathVariable String recipient) {
//        List<Notification> notifications = notificationService.getNotificationsForRecipient(recipient);
//        return ResponseEntity.ok(notifications);
//    }

    // Add more endpoints as needed (e.g., update notification status, delete notification, etc.)
}

