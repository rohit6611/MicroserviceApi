package com.app.mobile.api.login.request;

import java.util.Date;

import lombok.Builder;
import lombok.Data;





@Builder
@Data 

public class RequestLogin {
	
	String username;
	String password;
	String appPackage;
	String deviceId;
	int    platform;
    Date   timestamp;
    int    versionCode;
    
    
}
