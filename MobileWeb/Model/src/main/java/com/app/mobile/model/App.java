package com.app.mobile.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`app`")
public class App {
	@Id
	int id;
	String app_package;
	int versionCode;
	String storeLink;
	
	
}
