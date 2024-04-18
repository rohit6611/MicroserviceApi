package com.app.mobile.api.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/registerqtion")
public class RegisterationContoller {
	
	
	
	
	      @PostMapping
	   // @ResponseStatus(HttpStatus.CREATED)
	   // @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	   // @TimeLimiter(name = "inventory")
	   // @Retry(name = "inventory")
	    public String registerqtion(@RequestBody String orderRequest) {
	    	  
	    	//  User  mUSer=new User();
	    	  
	      //  log.info("Placing Order");
	        return "registerqtion";
	    }

}
