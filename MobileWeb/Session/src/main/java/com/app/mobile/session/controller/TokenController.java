package com.app.mobile.session.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mobile.database.repository.RepositorySession;
import com.app.mobile.model.Session;
import com.app.mobile.session.JWTUtil;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired 
	RepositorySession mRepositorySession;
    
    
    @GetMapping("/generateToken/{username}/{packageName}/{platform}/{deviceId}")
    public String generateToken(@PathVariable String username,@PathVariable String packageName,@PathVariable int platform,@PathVariable String deviceId) {
    	
    	
    	String subject=username+"_"+deviceId+"_"+packageName+"_"+platform;
    	Date issueDate=new Date(System.currentTimeMillis());
        Date exprireDate=new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1));
    	String token = jwtUtil.generateToken(subject,issueDate,exprireDate);
    	
    	
    	
    	Session mSession=new Session();
		mSession.setToken(token);
		mSession.setUserId(1);
		mSession.setPlatform(platform);
		mSession.setAppPackageName(packageName);
		mSession.setIssueDate(issueDate);
		mSession.setExpiryDate(exprireDate);
		mRepositorySession.save(mSession);
    	
    	
        return token;
    }


//    @PostMapping("/refreshToken")
//    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
//        // Validate the refresh token
//        if (!jwtUtil.isValidToken(refreshTokenRequest.getRefreshToken())) {
//            return ResponseEntity.badRequest().body("Invalid refresh token");
//        }
//
//        // Extract the username from the refresh token
//        String username = jwtUtil.getSubject(refreshTokenRequest.getRefreshToken());
//
//        // Generate a new access token
//        String newAccessToken = jwtUtil.generateToken(username);
//
//        // Return the new access token
//        return ResponseEntity.ok(newAccessToken);
//    }
    
    
    
    @GetMapping("/validateToken/{token}")
    public Boolean validateToken(@PathVariable String token) {
    	
    	try {
    	
        if (jwtUtil.isValidToken(token)) {
            return true;
        } else {
            return false;
        }
        
    	}catch(Exception e)

    	{
    		e.printStackTrace();
    		return false;
    		
    	}
    }

    @PostMapping("/validateTokenForUser")
    public ResponseEntity<String> validateTokenForUser(@RequestParam String token,@RequestParam String username,@RequestParam String packageName,@RequestParam String platform) {
        if (jwtUtil.isValidToken(token, username)) {
            return ResponseEntity.ok("Valid token for user " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token for user " + username);
        }
    }

    @GetMapping("/getUsernameFromToken")
    public ResponseEntity<String> getUsernameFromToken(@RequestParam String token) {
        String username = jwtUtil.getSubject(token);
        if (username != null) {
            return ResponseEntity.ok(username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
    

}

