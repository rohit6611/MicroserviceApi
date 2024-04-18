package com.app.mobile.api.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobile.api.login.request.RequestLogin;
import com.app.mobile.api.login.response.ResponseLogin;
import com.app.mobile.api.login.service.LoginService;


@RestController
@RequestMapping("/api/login")
public class loginController {

	
	   @Autowired LoginService mLoginService;

	    @PostMapping(consumes = {"application/json"})

	  //  @ResponseStatus(HttpStatus.CREATED)
	   // @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	   // @TimeLimiter(name = "inventory")
	   // @Retry(name = "inventory")
	    public ResponseLogin login(@RequestBody RequestLogin mRequestLogin) {
	     return	mLoginService.getResponse(mRequestLogin);
	    }
	    
	    
	    
	    
	    
	    @GetMapping("/test")
	    public String testGetEndpoint() {
	        return "This is a GET endpoint for testing purposes.";
	    }
	    
	    
	    
	    
	    

}
