package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.NotificationRepository;
import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.utility.Helper;
@Repository
public class NotificationRepositoryImpl extends JdbcDaoSupport implements NotificationRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public int createNotification(Notification notification) {
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		int saveFlag=getJdbcTemplate().update(
				"insert into COMPANY_ANNOUNCEMENTS (ANNC_TITLE,ANNC_DESCRIPTION,PUBLISHER_ID,"
				+ "STATUS_ID,CREATED_DATE,LAST_UPDATED_DATE,UPDATED_BY,VALID_TO) values(?,?,?,?,?,?,?,?)",notification.getHeading(),
				notification.getContent(),notification.getCreatorId(),"2",sysDate,sysDate,notification.getCreatorId(),
				notification.getExpiredOn());
		return saveFlag;
	}

	@Override
	public int saveToDetail(Notification notification,long annId) {
		int childFlag=0;
		for(String audience:notification.getAudienceLevel()) {
		childFlag=childFlag+getJdbcTemplate().update(
				"insert into ANNOUNCEMENT_DETAIL (ANNOUNCEMENT_ID,AUDIENCE_LEVEL) values(?,?)",
				annId,audience);
		}
		return childFlag;
	}

	@Override
	public long getAnnouncementId(String tittle) {
		long annId=getJdbcTemplate().queryForObject("SELECT ANNC_ID FROM COMPANY_ANNOUNCEMENTS WHERE ANNC_TITLE= ?",
				new Object[] { tittle },long.class);
		return annId;
	}

	@Override
	public int publishContent(long anncId,String sysDateWithTime) {
		return getJdbcTemplate().update("UPDATE COMPANY_ANNOUNCEMENTS set STATUS_ID = '0',"
				+ "PUBLISHED_DATE=? where ANNC_ID = ?",
				sysDateWithTime,anncId);
	}

	@Override
	public List<Notification> getAllContents() {
		System.out.println("DAO");
		return getJdbcTemplate().query(
				"SELECT COMPANY_ANNOUNCEMENTS.ANNC_ID,COMPANY_ANNOUNCEMENTS.ANNC_TITLE,"
						+ "COMPANY_ANNOUNCEMENTS.ANNC_DESCRIPTION,COMPANY_ANNOUNCEMENTS.PUBLISHER_ID,EMP_DETAIL.EMAIL,"
						+ "COMPANY_ANNOUNCEMENTS.STATUS_ID,MSTR_STATUS.STATUS_VALUE,"
						+ "COMPANY_ANNOUNCEMENTS.CREATED_DATE,COMPANY_ANNOUNCEMENTS.VALID_TO FROM COMPANY_ANNOUNCEMENTS JOIN EMP_DETAIL "
						+ "ON COMPANY_ANNOUNCEMENTS.PUBLISHER_ID=EMP_DETAIL.EMPLOYEE_ID LEFT JOIN MSTR_STATUS ON "
						+ "COMPANY_ANNOUNCEMENTS.STATUS_ID=MSTR_STATUS.STATUS_ID",
				(rs, rowNum) -> new Notification(rs.getLong("ANNC_ID"), rs.getString("ANNC_TITLE"),
						rs.getString("ANNC_DESCRIPTION"), rs.getString("PUBLISHER_ID"), rs.getString("EMAIL"),
						rs.getString("STATUS_ID"), rs.getString("STATUS_VALUE"), rs.getString("CREATED_DATE"),
						rs.getString("VALID_TO")));
	}

	@Override
	public List<Notification> getAllContentDetails(long anncId) {
		System.out.println("DAO ::getAllContentDetails"+anncId);
		return getJdbcTemplate().query("SELECT ANNOUNCEMENT_DETAIL.ANNOUNCEMENT_ID,"
				+ "ANNOUNCEMENT_DETAIL.AUDIENCE_LEVEL,MSTR_POSITION.POSITION_NAME "
				+ "FROM ANNOUNCEMENT_DETAIL "
				+ "LEFT OUTER  JOIN MSTR_POSITION ON ANNOUNCEMENT_DETAIL.AUDIENCE_LEVEL=MSTR_POSITION.POSITION_ID "
				+ "WHERE ANNOUNCEMENT_DETAIL.ANNOUNCEMENT_ID=?",
				new Object[] {anncId },
				(rs, rowNum) -> new Notification(rs.getLong("ANNOUNCEMENT_ID"), rs.getString("AUDIENCE_LEVEL"),
						rs.getString("POSITION_NAME")));
	}

	

	
	

	@Override
	public void deleteChild(long anncId) {
		jdbcTemplate.update("DELETE FROM ANNOUNCEMENT_DETAIL where ANNOUNCEMENT_ID=?", anncId);
		
	}

	

	@Override
	public int updateToAnnouncement(Notification notification,String loggedInUser) {
		System.out.println("DAO");
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		return getJdbcTemplate().update(
				"update COMPANY_ANNOUNCEMENTS set ANNC_TITLE = ?, ANNC_DESCRIPTION=?, STATUS_ID=?,"
				+ "LAST_UPDATED_DATE=?,UPDATED_BY=?,VALID_TO=? where ANNC_ID = ?",
				notification.getHeading(),notification.getContent(),notification.getStatusId(),sysDate,loggedInUser,notification.getExpiredOn(),
				notification.getAnncId());
	}

	@Override
	public int deleteContecntInMain(long anncId) {
		return getJdbcTemplate().update("DELETE FROM COMPANY_ANNOUNCEMENTS where ANNC_ID=?", anncId);
	}

}
