package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.Notification;

public interface NotificationService {
	
	int createNotification(Notification notification);
	int publishContent(long anncId, String comment);
	List<Notification> getAllContents();
	int updateContent(Notification notification,String loggedInUser);
	int deleteContecnt(long anncId);
	
}
