package com.gss.pulseworkflow.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gss.pulseworkflow.dao.NotificationRepository;
import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.service.NotificationService;
@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	@Transactional
	public int createNotification(Notification notification) {
		int childFlag=0;
		int saveFlag=notificationRepository.createNotification(notification);
		long annId=notificationRepository.getAnnouncementId(notification.getHeading());
		if(saveFlag>0) {
			childFlag=notificationRepository.saveToDetail(notification,annId);
		}
		return childFlag;
	}

	@Override
	public int publishContent(long anncId, String comment) {
		String sysDateWithTime=sysDatewithTime();
		return notificationRepository.publishContent(anncId,sysDateWithTime);
	}

	@Override
	public List<Notification> getAllContents() {
		//System.out.println("Service");
		List<Notification> notificationList=notificationRepository.getAllContents();
		System.out.println("Service ::"+notificationList);
		List<Notification> notificationDetailsList=null;
		Notification notificationData=null;
		List<Notification> finalList=new ArrayList<Notification>();
		for(Notification notification:notificationList) {
			//System.out.println("Service :: for"+notificationList);
			notificationDetailsList=notificationRepository.getAllContentDetails(notification.getAnncId());
			notificationData=listMap(notification,notificationDetailsList);
			finalList.add(notificationData);
		}
		System.out.println("DAO ::notificationDetailsList"+notificationDetailsList);
		//List<Notification> dataList=listMap(notificationList,notificationDetailsList);
		return finalList;
	}
	
	private Notification listMap(Notification notification,List<Notification> notificationDetailsList) {
		//System.out.println("DAO ::notificationDetailsList"+notificationDetailsList+"  notificationList::"+notificationList);
		
		//for(Notification notificationFinal: notificationList) {
			Map<String,String> audiencemap=new HashMap<String,String>();
			//System.out.println(" 1st DAO ::notificationDetailsList"+notificationDetailsList+"  notificationList::"+notificationList);
			for(Notification notificationdataMap:notificationDetailsList) {
				
				//System.out.println("2nd DAO ::notificationDetailsList"+notificationDetailsList+"  notificationList::"+notificationList);
				if(notification.getAnncId()==notificationdataMap.getAnncId()) {
					//System.out.println(" if ----DAO ::notificationDetailsList"+notificationDetailsList+"  notificationList::"+notificationList);
					/*
					 * if(notificationdataMap.getAudiencePositionName()==null ||
					 * !notificationdataMap.getAudiencePositionName().isEmpty()) {
					 * notificationdataMap.setAudiencePositionName("ALL"); }
					 */
					audiencemap.put(notificationdataMap.getAudiencePosition(), notificationdataMap.getAudiencePositionName());
				}
				
			}
			notification.setAudience(audiencemap);
		//}
		return notification;
	}

	@Override
	@Transactional
	public int updateContent(Notification notification,String loggedInUser) {
		// TODO Auto-generated method stub
		System.out.println("Service");
		int childUpdateFlag=0;
		int updateFlag=notificationRepository.updateToAnnouncement(notification,loggedInUser);
		if(updateFlag>0) {
			notificationRepository.deleteChild(notification.getAnncId());
			childUpdateFlag=notificationRepository.saveToDetail(notification, notification.getAnncId());
			
		}
		return childUpdateFlag;
	}

	@Override
	public int deleteContecnt(long anncId) {
		int deletedFlag = notificationRepository.deleteContecntInMain(anncId);
		if(deletedFlag>0) {
			notificationRepository.deleteChild(anncId);	
		}
		return deletedFlag;
	}
	
	private String sysDatewithTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
	    System.out.println("Before formatting: " + localDateTime);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    String formattedDate = localDateTime.format(myFormatObj);
	    System.out.println("After formatting: " + formattedDate);
	    return formattedDate;
	}

}
