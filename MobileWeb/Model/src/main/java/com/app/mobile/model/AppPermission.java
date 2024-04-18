package com.app.mobile.model;

import java.util.Date;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "`apppermission`")
public class AppPermission {

	@Id
	int id;
	int appId;
	int userId;
	Date timeStamp;
	
	
}
