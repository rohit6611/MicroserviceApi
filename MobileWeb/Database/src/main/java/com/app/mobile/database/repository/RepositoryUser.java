package com.app.mobile.database.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.app.mobile.model.User;


public interface RepositoryUser extends JpaRepository<User, Integer>{

	
	@Query("Select u from User u WHERE u.Username=:username and u.Password=:password and u.AppPackageName=:AppPackageName")
    User findByUsername(@Param("username") String username,@Param("password") String password,@Param("AppPackageName") String packageName);
	
	
}