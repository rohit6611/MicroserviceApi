package com.app.mobile.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mobile.model.Notification;

public interface RepositoryNotification extends JpaRepository<Notification, Integer>{

}
