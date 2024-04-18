package com.app.mobile.api.logout.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.model.User;




@RestController
@RequestMapping("/api/logout")
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "http://localhost:8080")
public class LogoutController {
	
	
	
	
	      @PostMapping
	   // @ResponseStatus(HttpStatus.CREATED)
	   // @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	   // @TimeLimiter(name = "inventory")
	   // @Retry(name = "inventory")
	    public String logout(@RequestBody String orderRequest) {
	    	  
	    	//  User  mUSer=new User();
	    	  
	      //  log.info("Placing Order");
	        return "Logout";
	    }

}