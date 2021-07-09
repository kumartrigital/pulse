package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.AssessmentRepository;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.Assessment1;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.AssessmtDeatilTemp;
import com.gss.pulseworkflow.model.EmpAssmtDetail;
import com.gss.pulseworkflow.utility.Helper;
@Repository
public class AssessmentRepositoryImpl extends JdbcDaoSupport implements AssessmentRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	@Override
	public int save(Assessment1 assessment) {
		assessment.setStatusId("2");
		return jdbcTemplate.update(
                "insert into ASSESSMENT_TEMP (ASSESSMENT_NAME,ASSESSMENT_TYPE,ASSESSMENT_PROJECT_ID,ASSESSEE_ID,ASSESS_INITIATED_DATE,ASSESS_END_DATE,ASSESSMENT_DESCRIPTION,ASSESSORS_ID,ASSESSMENT_STATUS_ID,CREATOR_ID) values(?,?,?,?,?,?,?,?,?,?)",
                assessment.getAssessmentName(),assessment.getAssessmentType(),assessment.getAssessProjId(),assessment.getAssesseeId(),assessment.getInitDate(),assessment.getEndDate(),assessment.getAssessmentDes(),assessment.getAssessorsId(),assessment.getStatusId(),assessment.getCreatorId());
	}

	@Override
	public List<Assessment1> findAll() {
		
		return jdbcTemplate.query("SELECT RCD_ID,ASSESSMENT_NAME,ASSESSMENT_TYPE,ASSESSMENT_PROJECT_ID,ASSESSEE_ID,ASSESS_INITIATED_DATE,ASSESS_END_DATE,ASSESSMENT_DESCRIPTION," 
				+" ASSESSORS_ID,ASSESSMENT_STATUS_ID FROM ASSESSMENT_TEMP",
				(rs, rowNum) ->
                new Assessment1(
                		rs.getLong("RCD_ID"),
                		rs.getString("ASSESSMENT_NAME"),
                		rs.getString("ASSESSMENT_TYPE"),
                		rs.getString("ASSESSMENT_PROJECT_ID"),
                		rs.getString("ASSESSEE_ID"),
                		rs.getString("ASSESS_INITIATED_DATE"),
                		rs.getString("ASSESS_END_DATE"),
                		rs.getString("ASSESSMENT_DESCRIPTION"),
                		rs.getString("ASSESSORS_ID"),
                		rs.getString("ASSESSMENT_STATUS_ID")));
	}

	@Override
	public String getAssmtIntervalType(String assmtInterId) {
		return jdbcTemplate.queryForObject(
                "SELECT INTERVAL_NAME FROM MSTR_ASSESSMENT_INTERVAL WHERE INTERVAL_ID=?",
                new Object[]{assmtInterId},
                String.class
        );
	}
	
	@Override
	public int createAssmt(Assessment assessment) {
		//assessment.setStatusId("2");;
		System.out.println("assessment DAO ::"+assessment);
		int addedFlag=0;
		addedFlag=jdbcTemplate.update(
                "insert into ASSESSMENT (ASSMT_ID,ASSMT_NAME,ASSMT_INTERVAL_ID,ASSNT_STATUS_ID,ASSMT_CREATED_DATE,ASSMT_CREATOR_ID,ASSMT_DESCRIPTION,LAST_UPDATED_DATE) values(?,?,?,?,?,?,?,?)",
                assessment.getRcdId(),assessment.getAssmtName(),assessment.getInterval(),"0",assessment.getCreatedDate(),assessment.getCreatorId(),assessment.getAssmtDes(),assessment.getCreatedDate());
		System.out.println("assessment DAO addedFlag::"+addedFlag);
		 return addedFlag;
	}
	@Override
	public int createAssmtTemp(Assessment assessment,String loggedInUser) {
		//assessment.setStatusId("2");;
		int addedFlag=0;
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		for(int i=0;i<assessment.getAssesseeIds().size();i++) {
		addedFlag=addedFlag+jdbcTemplate.update(
                "insert into ASSESSMENT_TEMP (ASSMT_NAME,ASSMT_INTERVAL_ID,ASSNT_STATUS_ID,ASSMT_CREATED_DATE,ASSMT_CREATOR_ID,ASSMT_DESCRIPTION,LAST_UPDATED_DATE) values(?,?,?,?,?,?,?)",
                assessment.getAssmtName(),assessment.getAssmtType(),"2",sysDate,loggedInUser,assessment.getAssmtDes(),sysDate);
		}
		 return addedFlag;
	}

	@Override
	public int createAssmtDetailWithProjectId(List<AssessmtDeatilTemp> assmtDetailTempList,long assmtId) {
		int updateCount=0;
		for(AssessmtDeatilTemp assessmtDeatilTemp:assmtDetailTempList) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL (ASSMT_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,PROJECT_ID) values(?,?,?,?,?,?,?)",
	                assmtId,assessmtDeatilTemp.getAssessorId(),"6",assessmtDeatilTemp.getInitDate(),"",assessmtDeatilTemp.getEndDate(),assessmtDeatilTemp.getProjectId());
		}
		return updateCount;
	}
	@Override
	public int createAssmtDetailWithProjectIdTemp(Assessment assessment,List<Long> rcdIds) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			for(Long assmtRcdId:rcdIds) {
			updateCount=updateCount+ jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_RCD_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,PROJECT_ID) values(?,?,?,?,?,?,?)",
	                assmtRcdId,assessor,"6",assessment.getInitDate(),"",assessment.getEndDate(),assessment.getProjectId());
		}
		}
		return updateCount;
	}

	/*
	 * @Override public long getAssmtIdByName(String assmtName) { return
	 * jdbcTemplate.query("select RCD_ID from ASSESSMENT_TEMP WHERE ASSMT_NAME=?",
	 * new Object[]{assmtName},(rs, rowNum) -> long.class); }
	 */
	@Override
	public List<Long> getAssmtIdByNameTemp(String assmtName) {
		return jdbcTemplate.query(
                "select RCD_ID from ASSESSMENT_TEMP WHERE ASSMT_NAME=?",
                new Object[]{assmtName},(rs, rowNum) ->
                new Long(rs.getLong("RCD_ID")));
	}

	@Override
	public int createAssmtDetailWithScheduled(List<AssessmtDeatilTemp> assmtDetailTempList, long assmtId) {
		int updateCount=0;
		for(AssessmtDeatilTemp assmtDetailTemp:assmtDetailTempList) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL (ASSMT_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,SCHEDULED_INTERVAL_MONTHS) values(?,?,?,?,?,?,?)",
	                assmtId,assmtDetailTemp.getAssessorId(),"6",assmtDetailTemp.getInitDate(),"",assmtDetailTemp.getEndDate(),assmtDetailTemp.getScheduledInterval());
		}
		return updateCount;
	}
	@Override
	public int createAssmtDetailWithScheduledTemp(Assessment assessment, List<Long> assmtRcdIds) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			for(Long assmtRcdId:assmtRcdIds) {
			updateCount= updateCount+jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_RCD_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,SCHEDULED_INTERVAL_MONTHS) values(?,?,?,?,?,?,?)",
	                assmtRcdId,assessor,"6",assessment.getInitDate(),"",assessment.getEndDate(),assessment.getInterval());
		}
		}
		return updateCount;
	}

	@Override
	public int createAssmtDetail(List<AssessmtDeatilTemp> assmtDetailTempList, long assmtId) {
		int updateCount=0;
		for(AssessmtDeatilTemp assmtDetailTemp: assmtDetailTempList) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL (ASSMT_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE) values(?,?,?,?,?,?)",
	                assmtId,assmtDetailTemp.getAssessorId(),"6",assmtDetailTemp.getInitDate(),"",assmtDetailTemp.getEndDate());
		}
		return updateCount;
	}
	@Override
	public int createAssmtDetailTemp(Assessment assessment, List<Long> assmtRcdIds) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			for(Long assmtRcdId:assmtRcdIds) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_RCD_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE) values(?,?,?,?,?,?)",
	                assmtRcdId,assessor,"6",assessment.getInitDate(),"",assessment.getEndDate());
		}
		}
		return updateCount;
	}

	@Override
	public int createAssmtToEmp(Assessment assessment) {
		int updateCount=0;
		//for(String assessee:assessment.getAssesseeIds()) {
			updateCount= jdbcTemplate.update(
	                "insert into EMP_ASSMT (EMPLOYEE_ID,ASSMT_ID,ASSNT_ASSIGNED_DATE,ASSMT_STATUS_ID) values(?,?,?,?)",
	                assessment.getAssesseeId(),assessment.getRcdId(),assessment.getCreatedDate(),"6");
		//}
		return updateCount;
	}
	@Override
	public int createAssmtToEmpTemp(Assessment assessment, List<Long> assmtRcdIds) {
		int updateCount=0;
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		for(int i=0;i<assessment.getAssesseeIds().size();i++) {
			updateCount=updateCount+ jdbcTemplate.update(
	                "insert into EMP_ASSMT_TEMP (EMPLOYEE_ID,ASSMT_RCD_ID,ASSNT_ASSIGNED_DATE,ASSMT_STATUS_ID) values(?,?,?,?)",
	                assessment.getAssesseeIds().get(i),assmtRcdIds.get(i),sysDate,"6");
		}
		return updateCount;
	}

	@Override
	public int createAssmtDetailWithProjectIdTemp(Assessment assessment, long assmtId) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,PROJECT_ID) values(?,?,?,?,?,?,?)",
	                assmtId,assessor,"6",assessment.getInitDate(),"",assessment.getEndDate(),assessment.getProjectId());
		}
		return updateCount;

	}
	
	@Override
	public int createAssmtDetailWithScheduledTemp(Assessment assessment, long assmtId) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,SCHEDULED_INTERVAL_MONTHS) values(?,?,?,?,?,?,?)",
	                assmtId,assessor,"6",assessment.getInitDate(),"",assessment.getEndDate(),assessment.getInterval());
		}
		return updateCount;
	}

	@Override
	public int createAssmtDetailTemp(Assessment assessment, long assmtId) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE) values(?,?,?,?,?,?)",
	                assmtId,assessor,"6",assessment.getInitDate(),"",assessment.getEndDate());
		}
		return updateCount;
	}

	@Override
	public int publish(long assmtId) {
		return jdbcTemplate.update(
                "update ASSESSMENT set ASSNT_STATUS_ID = '0' where ASSMT_ID = ?",
                assmtId);
	}

	@Override
	public List<Assessment> getAllAssessments() {
		return jdbcTemplate.query("SELECT ASSESSMENT_TEMP.RCD_ID AS RCDID,ASSESSMENT_TEMP.ASSMT_NAME AS ASSMTNAME,ASSESSMENT_TEMP.ASSMT_INTERVAL_ID AS ASSMTINTERVAL,"
				+ " MSTR_ASSESSMENT_INTERVAL.INTERVAL_NAME AS INTERVALNAME,"
				+ " ASSESSMENT_TEMP.ASSNT_STATUS_ID AS STATUSID,MSTR_STATUS.STATUS_VALUE AS STATUS,"
				+ " ASSESSMENT_TEMP.ASSNT_DTL_STATUS_ID AS DTLSTATUSID,ASSESSMENT_TEMP.ASSMT_SUMMARY AS SUMMARY,ASSESSMENT_TEMP.ASSMT_CREATED_DATE AS "
				+ " CREATEDDATE,ASSESSMENT_TEMP.ASSMT_DESCRIPTION AS ASSMTDESC,ASSESSMENT_TEMP.LAST_UPDATED_DATE AS UPDATEDDATE FROM ASSESSMENT_TEMP JOIN "
				+ " MSTR_ASSESSMENT_INTERVAL ON MSTR_ASSESSMENT_INTERVAL.INTERVAL_ID=ASSESSMENT_TEMP.ASSMT_INTERVAL_ID LEFT JOIN "
				+ " MSTR_STATUS ON MSTR_STATUS.STATUS_ID=ASSESSMENT_TEMP.ASSNT_STATUS_ID",
				(rs, rowNum) ->
                new Assessment(
                		rs.getLong("RCDID"),
                		rs.getString("ASSMTNAME"),
                		rs.getString("ASSMTINTERVAL"),
                		rs.getString("INTERVALNAME"),
                		rs.getString("STATUSID"),
                		rs.getString("STATUS"),
                		rs.getString("DTLSTATUSID"),
                		rs.getString("SUMMARY"),
                		rs.getString("CREATEDDATE"),
                		rs.getString("ASSMTDESC"),
                		rs.getString("UPDATEDDATE")));
	}

	@Override
	public List<AssessmentChild> getAssessmentDtlAndEmpAssmt(Assessment assessment) {
		String projectIdAvilableQueryFlag="";
		String projectIdAvilableCondition="";
		
		  if(assessment.getIntervalTypeValue().equalsIgnoreCase("PROJECT")) {
		  projectIdAvilableQueryFlag="PROJECTS.PROJECT_NAME AS PROJECTNAME,";
		  projectIdAvilableCondition=" PROJECTS ON ASSMT_DETAIL_TEMP.PROJECT_ID=PROJECTS.PROJECT_ID LEFT JOIN ";
		  
		  }else { projectIdAvilableQueryFlag="ASSMT_DETAIL_TEMP.PROJECT_ID AS PROJECTNAME,";
		  }
		 
		//System.out.println();
		String query="SELECT ASSMT_DETAIL_TEMP.RCD_ID AS ASSMTDETAILRCDID,"
		 		+ "ASSMT_DETAIL_TEMP.ASSMT_RCD_ID AS ASSMTRCDID,ASSMT_DETAIL_TEMP.ASSNT_ASSESSOR_ID AS ASSESSORID,"
		 		+ "EMP.EMAIL AS ASSESSOREMAIL,ASSMT_DETAIL_TEMP.ASSNT_STATUS_ID AS ASSMTDTLSTATUSID,"
		 		+ "ASSMT_DETAIL_TEMP.ASSMT_OUTCOME AS ASSMTOUTCOME,ASSMT_DETAIL_TEMP.ASSMT_INIT_DATE AS STARTDATE,"
		 		+ "ASSMT_DETAIL_TEMP.ASSMT_COMPLETED_DATE AS COMPLETEDDATE,ASSMT_DETAIL_TEMP.ASSMT_DUE_DATE AS ENDDATE,"
		 		+ "ASSMT_DETAIL_TEMP.PROJECT_ID AS PROJECTID,"+projectIdAvilableQueryFlag
		 		+ "ASSMT_DETAIL_TEMP.ASSMT_COMMENT AS ASSMTCOMMENTS,ASSMT_DETAIL_TEMP.SCHEDULED_INTERVAL_MONTHS AS SCHEDULEDINTERVALS,"
		 		+ "EMPASSMT.RCD_ID AS EMPASSMTRCDID,EMPASSMT.EMPLOYEE_ID AS ASSESSEEID,"
		 		+ "EMP2.EMAIL AS assesseeemail,EMPASSMT.ASSNT_ASSIGNED_DATE AS EMPASSMTASSIGNEDDATE,"
		 		+ "EMPASSMT.ASSMT_INIT_ID AS EMPASSMTINITID,EMPASSMT.ASSMT_STATUS_ID AS EMPASSMTSTATUSID,"
		 		+ "MSTR_STATUS.STATUS_VALUE AS DTLSTATUSVALUE FROM "
		 		+ "ASSMT_DETAIL_TEMP JOIN"+projectIdAvilableCondition+ " EMP_DETAIL EMP ON EMP.EMPLOYEE_ID=ASSMT_DETAIL_TEMP.ASSNT_ASSESSOR_ID "
		 		+ "LEFT JOIN EMP_ASSMT_TEMP EMPASSMT ON EMPASSMT.ASSMT_RCD_ID=ASSMT_DETAIL_TEMP.ASSMT_RCD_ID"
		 		+ " LEFT JOIN EMP_DETAIL EMP2 ON EMP2.EMPLOYEE_ID=EMPASSMT.EMPLOYEE_ID LEFT JOIN "
		 		+ "MSTR_STATUS ON MSTR_STATUS.STATUS_ID=ASSMT_DETAIL_TEMP.ASSNT_STATUS_ID "
		 		+ "WHERE ASSMT_DETAIL_TEMP.ASSMT_RCD_ID=?";
		//System.out.println(query);
		 return jdbcTemplate.query("SELECT ASSMT_DETAIL_TEMP.RCD_ID AS ASSMTDETAILRCDID,"
			 		+ "ASSMT_DETAIL_TEMP.ASSMT_RCD_ID AS ASSMTRCDID,ASSMT_DETAIL_TEMP.ASSNT_ASSESSOR_ID AS ASSESSORID,"
			 		+ "EMP.EMAIL AS ASSESSOREMAIL,ASSMT_DETAIL_TEMP.ASSNT_STATUS_ID AS ASSMTDTLSTATUSID,"
			 		+ "ASSMT_DETAIL_TEMP.ASSMT_OUTCOME AS ASSMTOUTCOME,ASSMT_DETAIL_TEMP.ASSMT_INIT_DATE AS STARTDATE,"
			 		+ "ASSMT_DETAIL_TEMP.ASSMT_COMPLETED_DATE AS COMPLETEDDATE,ASSMT_DETAIL_TEMP.ASSMT_DUE_DATE AS ENDDATE,"
			 		+ "ASSMT_DETAIL_TEMP.PROJECT_ID AS PROJECTID,"+projectIdAvilableQueryFlag
			 		+ "ASSMT_DETAIL_TEMP.ASSMT_COMMENT AS ASSMTCOMMENTS,ASSMT_DETAIL_TEMP.SCHEDULED_INTERVAL_MONTHS AS SCHEDULEDINTERVALS,"
			 		+ "EMPASSMT.RCD_ID AS EMPASSMTRCDID,EMPASSMT.EMPLOYEE_ID AS ASSESSEEID,"
			 		+ "EMP2.EMAIL AS assesseeemail,EMPASSMT.ASSNT_ASSIGNED_DATE AS EMPASSMTASSIGNEDDATE,"
			 		+ "EMPASSMT.ASSMT_INIT_ID AS EMPASSMTINITID,EMPASSMT.ASSMT_STATUS_ID AS EMPASSMTSTATUSID,"
			 		+ "MSTR_STATUS.STATUS_VALUE AS DTLSTATUSVALUE FROM "
			 		+ "ASSMT_DETAIL_TEMP JOIN"+projectIdAvilableCondition+ " EMP_DETAIL EMP ON EMP.EMPLOYEE_ID=ASSMT_DETAIL_TEMP.ASSNT_ASSESSOR_ID "
			 		+ "LEFT JOIN EMP_ASSMT_TEMP EMPASSMT ON EMPASSMT.ASSMT_RCD_ID=ASSMT_DETAIL_TEMP.ASSMT_RCD_ID"
			 		+ " LEFT JOIN EMP_DETAIL EMP2 ON EMP2.EMPLOYEE_ID=EMPASSMT.EMPLOYEE_ID LEFT JOIN "
			 		+ "MSTR_STATUS ON MSTR_STATUS.STATUS_ID=ASSMT_DETAIL_TEMP.ASSNT_STATUS_ID "
			 		+ "WHERE ASSMT_DETAIL_TEMP.ASSMT_RCD_ID=?",
				new Object[]{assessment.getAssmtId()},(rs, rowNum) ->
                new AssessmentChild(
                		rs.getLong("ASSMTDETAILRCDID"),
                		rs.getString("ASSMTRCDID"),
                		rs.getString("ASSESSORID"),
                		rs.getString("ASSESSOREMAIL"),
                		rs.getString("ASSMTDTLSTATUSID"),
                		rs.getString("ASSMTOUTCOME"),
                		rs.getString("STARTDATE"),
                		rs.getString("COMPLETEDDATE"),
                		rs.getString("ENDDATE"),
                		rs.getString("PROJECTID"),
                		rs.getString("PROJECTNAME"),
                		rs.getString("ASSMTCOMMENTS"),
                		rs.getString("SCHEDULEDINTERVALS"),
                		rs.getLong("EMPASSMTRCDID"),
                		rs.getString("ASSESSEEID"),
                		rs.getString("ASSESSEEEMAIL"),
                		rs.getString("EMPASSMTASSIGNEDDATE"),
                		rs.getString("EMPASSMTINITID"),
                		rs.getString("EMPASSMTSTATUSID"),
                		rs.getString("DTLSTATUSVALUE")));
	}

	@Override
	public int updateAssessment(Assessment assessment) {
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		return jdbcTemplate.update(
                "update ASSESSMENT_TEMP SET ASSMT_INTERVAL_ID=?,ASSMT_NAME=?,ASSMT_DESCRIPTION=?,LAST_UPDATED_DATE=? where RCD_ID=?",
                assessment.getAssmtType(),assessment.getAssmtName(),assessment.getAssmtDes(),sysDate,assessment.getAssmtId());
	}

	@Override
	public int updateAssmtDetailWithProjectId(Assessment assessment) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			updateCount=updateCount+ jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_RCD_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,PROJECT_ID) values(?,?,?,?,?,?,?)",
	                assessment.getAssmtId(),assessor,"6",assessment.getInitDate(),"",assessment.getEndDate(),assessment.getProjectId());
		}
		return updateCount;
	}

	@Override
	public int updateAssmtDetailWithScheduled(Assessment assessment) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			updateCount= updateCount+jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_RCD_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE,SCHEDULED_INTERVAL_MONTHS) values(?,?,?,?,?,?,?)",
	                assessment.getAssmtId(),assessor,"6",assessment.getInitDate(),"",assessment.getEndDate(),assessment.getInterval());
		}
		return updateCount;
	}

	@Override
	public int updateAssmtDetail(Assessment assessment) {
		int updateCount=0;
		for(String assessor:assessment.getAssessors()) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSMT_DETAIL_TEMP (ASSMT_RCD_ID,ASSNT_ASSESSOR_ID,ASSNT_STATUS_ID,ASSMT_INIT_DATE,ASSMT_COMPLETED_DATE,ASSMT_DUE_DATE) values(?,?,?,?,?,?)",
	                assessment.getAssmtId(),assessor,"6",assessment.getInitDate(),"",assessment.getEndDate());
		}
		return updateCount;
	}

	@Override
	public int updateAssmtToEmp(Assessment assessment) {
		int updateCount=0;
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
			updateCount=updateCount+ jdbcTemplate.update(
	                "insert into EMP_ASSMT_TEMP (EMPLOYEE_ID,ASSMT_RCD_ID,ASSNT_ASSIGNED_DATE,ASSMT_STATUS_ID) values(?,?,?,?)",
	                assessment.getAssesseeIds().get(0),assessment.getAssmtId(),sysDate,"6");
		return updateCount;
	}
	
	@Override
	public String getStatus(long assmtId) {
		return jdbcTemplate.queryForObject(
                "SELECT STATUS_VALUE FROM MSTR_STATUS WHERE STATUS_ID IN (SELECT ASSNT_STATUS_ID FROM ASSESSMENT WHERE ASSMT_ID=?)",
                new Object[]{assmtId},
                String.class
        );
	}
	@Override
	public int deleteByIdStatus(long assmtId) {
		return jdbcTemplate.update(
                "update ASSESSMENT set ASSNT_STATUS_ID = '1' where ASSMT_ID = ?",
                assmtId);
	}
	@Override
	public int deleteById(long assmtId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "DELETE FROM ASSESSMENT_TEMP where RCD_ID=?",
                assmtId);
	}
	@Override
	public int deleteByIdChildAssmtDtl(long assmtId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "DELETE FROM ASSMT_DETAIL_TEMP where ASSMT_RCD_ID=?",
                assmtId);
	}
	
	@Override
	public int deleteByIdChildAssmtEmp(long assmtId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "DELETE FROM EMP_ASSMT_TEMP where ASSMT_RCD_ID=?",
                assmtId);
	}

	@Override
	public int createAssmtToTemp(Assessment assessment) {
		int updateCount=0;
		List<String> assesseeIds=assessment.getAssesseeIds();
		List<String> assessorIds=assessment.getAssessors();
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		for(String assesseeId:assesseeIds) {
			for(String assessorId:assessorIds) {
			updateCount= jdbcTemplate.update(
	                "insert into ASSESSMENT_DYNAMIC_TEMP (ASSESSMENT_NAME,ASSESSMENT_INTERVAL_TYPE,ASSESSMENT_DESCRIPTION,STATUS_ID,ASSMT_CREATED_DATE,ASSMT_ASSESSOR_ID,ASSESSMENT_PROJECT_ID,ASSMT_STATUS_ID,ASSESSEE_ID,"
	                + "ASSESS_INITIATED_DATE,ASSESS_END_DATE,SCHEDULED_INTERVAL_MONTHS,CREATOR_ID) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
	                assessment.getAssmtName(),assessment.getAssmtType(),assessment.getAssmtDes(),"2",sysDate, assessorId,assessment.getProjectId(),"",assesseeId,assessment.getInitDate(),assessment.getEndDate(),assessment.getInterval(),"");
		}
	}
		return updateCount;


}
	@Override
	public List<EmpAssmtDetail> assmtCapabilityRoleByProjectId(String projectId, long assmtId) {
		return jdbcTemplate.query("SELECT ASSMT_DETAIL.RCD_ID AS DTLRCDID,ASSMT_DETAIL.ASSMT_ID AS ASSMTID,"
				+ "ASSMT_DETAIL.ASSNT_ASSESSOR_ID AS ASSESSORID,ASSMT_DETAIL.PROJECT_ID AS PROJECTID,"
				+ "EMP_ASSMT.RCD_ID AS EMPRCDID,EMP_ASSMT.EMPLOYEE_ID AS ASSESSEE,EMP_PROJECT.PROJ_POSITION_ID AS PROJECTROLE "
				+ "FROM ASSMT_DETAIL JOIN EMP_ASSMT ON ASSMT_DETAIL.ASSMT_ID=EMP_ASSMT.ASSMT_ID LEFT JOIN EMP_PROJECT ON "
				+ "(ASSMT_DETAIL.PROJECT_ID=EMP_PROJECT.PROJECT_ID && EMP_ASSMT.EMPLOYEE_ID=EMP_PROJECT.EMPLOYEE_ID) "
				+ "WHERE ASSMT_DETAIL.ASSMT_ID=? AND ASSMT_DETAIL.PROJECT_ID=?",new Object[] { assmtId, projectId },
				(rs, rowNum) ->
                new EmpAssmtDetail(
                		rs.getString("DTLRCDID"),
                		rs.getString("ASSMTID"),
                		rs.getString("ASSESSORID"),
                		rs.getString("PROJECTID"),
                		rs.getString("EMPRCDID"),
                		rs.getString("ASSESSEE"),
                		rs.getString("PROJECTROLE")));
	}
	@Override
	public List<EmpAssmtDetail> assmtCapabilityRoleByBasic(long assmtId) {
		return jdbcTemplate.query("SELECT ASSMT_DETAIL.RCD_ID AS DTLRCDID,ASSMT_DETAIL.ASSMT_ID AS ASSMTID,"
				+ "ASSMT_DETAIL.ASSNT_ASSESSOR_ID AS ASSESSORID,ASSMT_DETAIL.PROJECT_ID AS PROJECTID,"
				+ "EMP_ASSMT.RCD_ID AS EMPRCDID,EMP_ASSMT.EMPLOYEE_ID AS ASSESSEE,EMP_DETAIL.POSITION AS PROJECTROLE "
				+ "FROM ASSMT_DETAIL JOIN EMP_ASSMT ON ASSMT_DETAIL.ASSMT_ID=EMP_ASSMT.ASSMT_ID LEFT JOIN EMP_DETAIL ON "
				+ "EMP_ASSMT.EMPLOYEE_ID=EMP_DETAIL.EMPLOYEE_ID WHERE ASSMT_DETAIL.ASSMT_ID=?",new Object[] { assmtId},
				(rs, rowNum) ->
				 new EmpAssmtDetail(
	                		rs.getString("DTLRCDID"),
	                		rs.getString("ASSMTID"),
	                		rs.getString("ASSESSORID"),
	                		rs.getString("PROJECTID"),
	                		rs.getString("EMPRCDID"),
	                		rs.getString("ASSESSEE"),
	                		rs.getString("PROJECTROLE")));
	}
	@Override
	public List<String> getassociateCapabilitiesByRole(String role) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT POSITION_DETAIL.CAPABILITY_ID FROM POSITION_DETAIL WHERE POSITION_DETAIL.POSITION_ID=?",
				new Object[] { role},
				(rs, rowNum) ->
				 new String(rs.getString("CAPABILITY_ID")));
	}
	@Override
	public int createAssmtCapabilities(EmpAssmtDetail empAssmtDetail, String capability) {
		Helper helper=new Helper();
		String sysDate=helper.getSystemDate();
		return jdbcTemplate.update(
                "INSERT INTO ASSMT_CAPBLTY(ASSMT_ID,ASSMT_DTL_RCD,EMP_ASSMT_RCD,ASSESSEE_POSITION,ASSMT_CAPABILITY_ID,"
                + "LAST_UPDATED_DATE,ASSMT_COMPLETED_STATUS) VALUES (?,?,?,?,?,?,?)",
                empAssmtDetail.getAssmtId(),empAssmtDetail.getDtlRcdId(),empAssmtDetail.getEmpAssmtRcdId(),empAssmtDetail.getAssesseeRole(),
                capability,sysDate,"6");
	}
	@Override
	public Assessment getAssmtBasicData(long assmtId) {
		return jdbcTemplate.queryForObject("SELECT ASSMTTMP.RCD_ID,ASSMTTMP.ASSMT_NAME,ASSMTTMP.ASSMT_INTERVAL_ID,"
				+ "ASSMTTMP.ASSNT_STATUS_ID,ASSMTTMP.ASSNT_DTL_STATUS_ID,ASSMTTMP.ASSMT_SUMMARY,"
				+ "ASSMTTMP.ASSMT_CREATED_DATE,ASSMTTMP.ASSMT_CREATOR_ID,ASSMTTMP.ASSMT_DESCRIPTION,"
				+ "ASSMTTMP.LAST_UPDATED_DATE,EMP_ASSMT_TEMP.EMPLOYEE_ID FROM ASSESSMENT_TEMP ASSMTTMP JOIN EMP_ASSMT_TEMP "
				+ "ON EMP_ASSMT_TEMP.ASSMT_RCD_ID=ASSMTTMP.RCD_ID WHERE ASSMTTMP.RCD_ID=?",
				new Object[] { assmtId},
				(rs, rowNum) ->
				 new Assessment(rs.getString("ASSMT_NAME"),
						 rs.getString("ASSMT_INTERVAL_ID"),
						 rs.getString("ASSNT_STATUS_ID"),
						 rs.getString("ASSNT_DTL_STATUS_ID"),
						 rs.getString("ASSMT_SUMMARY"),
						 rs.getString("ASSMT_CREATED_DATE"),
						 rs.getString("ASSMT_CREATOR_ID"),
						 rs.getString("ASSMT_DESCRIPTION"),
						 rs.getString("LAST_UPDATED_DATE"),
						 rs.getString("EMPLOYEE_ID"),rs.getLong("RCD_ID")));
	}
	@Override
	public List<AssessmtDeatilTemp> getAssmtDeatilData(long assmtId) {
		return jdbcTemplate.query("SELECT ASSMT_DETAIL_TEMP.ASSNT_ASSESSOR_ID,ASSMT_DETAIL_TEMP.ASSNT_STATUS_ID,"
				+ "ASSMT_DETAIL_TEMP.ASSMT_OUTCOME,ASSMT_DETAIL_TEMP.ASSMT_INIT_DATE,ASSMT_DETAIL_TEMP.ASSMT_COMPLETED_DATE,"
				+ "ASSMT_DETAIL_TEMP.ASSMT_DUE_DATE,ASSMT_DETAIL_TEMP.PROJECT_ID,ASSMT_DETAIL_TEMP.ASSMT_COMMENT,"
				+ "ASSMT_DETAIL_TEMP.SCHEDULED_INTERVAL_MONTHS FROM ASSMT_DETAIL_TEMP WHERE ASSMT_DETAIL_TEMP.ASSMT_RCD_ID=?",
				new Object[] { assmtId},
				(rs, rowNum) ->
				 new AssessmtDeatilTemp(rs.getString("ASSNT_ASSESSOR_ID"),
						 rs.getString("ASSNT_STATUS_ID"),
						 rs.getString("ASSMT_OUTCOME"),
						 rs.getString("ASSMT_INIT_DATE"),
						 rs.getString("ASSMT_COMPLETED_DATE"),
						 rs.getString("ASSMT_DUE_DATE"),
						 rs.getString("PROJECT_ID"),
						 rs.getString("ASSMT_COMMENT"),
						 rs.getString("SCHEDULED_INTERVAL_MONTHS")
						 ));
	}
	@Override
	public void deleteAssmtDataFromTemp(long rcdId) {
		jdbcTemplate.update(
                "DELETE FROM ASSESSMENT_TEMP where RCD_ID=?",
                rcdId);
		jdbcTemplate.update(
                "DELETE FROM EMP_ASSMT_TEMP where ASSMT_RCD_ID=?",
                rcdId);
		
	}
	@Override
	public void deleteAssmtDetailDataFromTemp(long rcdId) {
		jdbcTemplate.update(
                "DELETE FROM ASSMT_DETAIL_TEMP where ASSMT_RCD_ID=?",
                rcdId);
		
	}
	@Override
	public List<Assessment> assessmentSearch(String query) {
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
                new Assessment(
                		rs.getLong("RCDID"),
                		rs.getString("ASSMTNAME"),
                		rs.getString("ASSMTINTERVAL"),
                		rs.getString("INTERVALNAME"),
                		rs.getString("STATUSID"),
                		rs.getString("STATUS"),
                		rs.getString("DTLSTATUSID"),
                		rs.getString("SUMMARY"),
                		rs.getString("CREATEDDATE"),
                		rs.getString("ASSMTDESC"),
                		rs.getString("UPDATEDDATE")));
	}
	
	/*
	 * public static void main(String args[]) {
	 * 
	 * }
	 */
}