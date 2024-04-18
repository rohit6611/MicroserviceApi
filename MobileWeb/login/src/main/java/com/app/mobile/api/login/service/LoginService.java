package com.app.mobile.api.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mobile.api.login.request.RequestLogin;
import com.app.mobile.api.login.response.ResponseLogin;
import com.app.mobile.database.repository.RepositorySession;
import com.app.mobile.database.repository.RepositoryUser;
import com.app.mobile.model.AppPermission;
import com.app.mobile.model.Session;
import com.app.mobile.model.User;

import lombok.RequiredArgsConstructor;

import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor

public class LoginService {

	@Autowired
	RepositoryUser mRepositoryUser;
	
	@Autowired 
	RepositorySession mRepositorySession;
	
	  private final WebClient.Builder webClientBuilder ;
	

	public ResponseLogin getResponse(RequestLogin mRequestLogin) {
		String Username = mRequestLogin.getUsername();
		String Password = mRequestLogin.getPassword();
		int platform = mRequestLogin.getPlatform();
		String deviceId=mRequestLogin.getDeviceId();
		String AppPackageName=mRequestLogin.getAppPackage();

		User user = mRepositoryUser.findByUsername(Username, Password,AppPackageName);
		 
		ResponseLogin responseLogin = new ResponseLogin();

		if (user != null) {
			responseLogin.setUser(user);
			responseLogin.setToken(createNewSession(Username,platform,deviceId,AppPackageName));
			responseLogin.setStatusCode(200);
		} else {
			responseLogin.setStatusCode(901);
			responseLogin.setMessage("Please check username and password");
		}

		return responseLogin;

	}

	public String createNewSession(String  Username,Integer platform,String deviceId,String AppPackageName) {
		
		
	
		String token = webClientBuilder.baseUrl("http://192.168.1.193:4444").build().get()
		        .uri(uriBuilder -> uriBuilder
		                .path("/api/token/generateToken/{Username}/{platform}/{deviceId}/{AppPackageName}")
		                .build(Username, platform, deviceId,AppPackageName))
		        .retrieve()
		        .bodyToMono(String.class)
		        .block();
		
		

		return token;

	}

	public AppPermission getAppPermission() {

		return null;
	}

	
	
	
	
}
