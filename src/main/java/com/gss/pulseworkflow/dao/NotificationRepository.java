package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.Notification;

public interface NotificationRepository {
	int createNotification(Notification notification);
	int saveToDetail(Notification notification,long annId);
	long getAnnouncementId(String tittle);
	int publishContent(long anncId,String sysDateWithTime);
	List<Notification> getAllContents();
	List<Notification> getAllContentDetails(long anncId);
	int updateToAnnouncement(Notification notification,String loggedInUser);
	void deleteChild(long anncId);
	int deleteContecntInMain(long anncId);
}
