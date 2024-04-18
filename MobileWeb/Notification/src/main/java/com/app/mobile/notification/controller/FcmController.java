package com.app.mobile.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobile.database.repository.RepositoryFcm;
import com.app.mobile.model.FcmToken;



@RestController
@RequestMapping("/api/fcm")
public class FcmController {
	
	
	
	
	 @Autowired
	 RepositoryFcm mRepositoryFcm;
	
	
	      @PostMapping
	   // @ResponseStatus(HttpStatus.CREATED)
	   // @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	   // @TimeLimiter(name = "inventory")
	   // @Retry(name = "inventory")
	    public String FCM(@RequestBody String fcmRequest) {
	    	  
	    	  
	      //  log.info("Placing Order");
	        return "FCM";
	    }
	      
	      
	      
	      @PostMapping
	      public ResponseEntity<FcmToken>  save(@RequestBody FcmToken fcmToken) {
	          FcmToken createdFcmToken = mRepositoryFcm.save(fcmToken);
	          return new ResponseEntity<>(createdFcmToken, HttpStatus.CREATED);
	      }

}
