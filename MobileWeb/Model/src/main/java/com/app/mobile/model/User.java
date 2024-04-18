package com.app.mobile.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`user`")
@Proxy(lazy = false)
//@EntityListeners(userListenner.class)
@Data
public class User {
	@Id
	Integer    Id;
	String 	   FirstName;
	String     LastName;
	String     Name;
	Date       DOB;
	String     EmailId;
	String     MobileNo;
	String     loginType;
	Integer    isMobileNumberVerify;
	Integer    isEmailIdVerify;
	String     ProfileImageUrl;
	Date       LastLogin;
	String     Username;
    String     AppPackageName;
	@JsonIgnore
	String     Password;
	
	
	// Education info 
	// Company info 
	// Personal info 
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FcmToken> fcmTokens = new ArrayList<FcmToken>();

}
