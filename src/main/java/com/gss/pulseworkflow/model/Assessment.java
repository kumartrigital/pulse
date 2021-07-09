package com.gss.pulseworkflow.model;

import java.util.HashMap;
import java.util.List;

public class Assessment {
	private long rcdId;
	private long assmtId;
	private String assmtType;
	private List<String> assesseeIds;
	private String initDate;
	private String endDate;
	private String assmtDes;
	private List<String> assessors;
	private String interval;
	private boolean staticFlag;
	private String projectId;
	private String statusId;
	private String assmtName;
	private String dtlStatusId;
	private String summary;
	private String createdDate;
	private String intervalTypeValue;
	private String status;
	private String lastUpdatedDate;
	private HashMap<String, String> accessors;
	private HashMap<String, String> assessees;

	private long assmtDtlRcdId;
	private String assmtDtlStatusId;
	private String assmtDtlStatusValue;
	private String assmtOutcome;
	private String assmtCompletedDate;
	private String projectName;
	private String assmtComments;
	private long empAssmtRcdId;
	private String empAssmtAssignedDate;
	private String empInitId;
	private String empAssmtStatusId;
	private String assesseeId;
	private String creatorId;
	private List<AssmtCapability> assmtCapabilities;
	

	public String getAssesseeId() {
		return assesseeId;
	}

	public void setAssesseeId(String assesseeId) {
		this.assesseeId = assesseeId;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getAssmtDtlStatusValue() {
		return assmtDtlStatusValue;
	}

	public void setAssmtDtlStatusValue(String assmtDtlStatusValue) {
		this.assmtDtlStatusValue = assmtDtlStatusValue;
	}

	public List<AssmtCapability> getAssmtCapabilities() {
		return assmtCapabilities;
	}

	public void setAssmtCapabilities(List<AssmtCapability> assmtCapabilities) {
		this.assmtCapabilities = assmtCapabilities;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId, String assmtName, String dtlStatusId, String summary, String createdDate,
			String intervalTypeValue, String status, String lastUpdatedDate, HashMap<String, String> accessors,
			HashMap<String, String> assessees, long assmtDtlRcdId, String assmtDtlStatusId, String assmtOutcome,
			String assmtCompletedDate, String projectName, String assmtComments, long empAssmtRcdId,
			String empAssmtAssignedDate, String empInitId, String empAssmtStatusId,
			List<AssmtCapability> assmtCapabilities) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
		this.assmtName = assmtName;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.intervalTypeValue = intervalTypeValue;
		this.status = status;
		this.lastUpdatedDate = lastUpdatedDate;
		this.accessors = accessors;
		this.assessees = assessees;
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.assmtDtlStatusId = assmtDtlStatusId;
		this.assmtOutcome = assmtOutcome;
		this.assmtCompletedDate = assmtCompletedDate;
		this.projectName = projectName;
		this.assmtComments = assmtComments;
		this.empAssmtRcdId = empAssmtRcdId;
		this.empAssmtAssignedDate = empAssmtAssignedDate;
		this.empInitId = empInitId;
		this.empAssmtStatusId = empAssmtStatusId;
		this.assmtCapabilities = assmtCapabilities;
	}

	public long getAssmtDtlRcdId() {
		return assmtDtlRcdId;
	}

	public void setAssmtDtlRcdId(long assmtDtlRcdId) {
		this.assmtDtlRcdId = assmtDtlRcdId;
	}

	public String getAssmtDtlStatusId() {
		return assmtDtlStatusId;
	}

	public void setAssmtDtlStatusId(String assmtDtlStatusId) {
		this.assmtDtlStatusId = assmtDtlStatusId;
	}

	public String getAssmtOutcome() {
		return assmtOutcome;
	}

	public void setAssmtOutcome(String assmtOutcome) {
		this.assmtOutcome = assmtOutcome;
	}

	public String getAssmtCompletedDate() {
		return assmtCompletedDate;
	}

	public void setAssmtCompletedDate(String assmtCompletedDate) {
		this.assmtCompletedDate = assmtCompletedDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getAssmtComments() {
		return assmtComments;
	}

	public void setAssmtComments(String assmtComments) {
		this.assmtComments = assmtComments;
	}

	public long getEmpAssmtRcdId() {
		return empAssmtRcdId;
	}

	public void setEmpAssmtRcdId(long empAssmtRcdId) {
		this.empAssmtRcdId = empAssmtRcdId;
	}

	public String getEmpAssmtAssignedDate() {
		return empAssmtAssignedDate;
	}

	public void setEmpAssmtAssignedDate(String empAssmtAssignedDate) {
		this.empAssmtAssignedDate = empAssmtAssignedDate;
	}

	public String getEmpInitId() {
		return empInitId;
	}

	public void setEmpInitId(String empInitId) {
		this.empInitId = empInitId;
	}

	public String getEmpAssmtStatusId() {
		return empAssmtStatusId;
	}

	public void setEmpAssmtStatusId(String empAssmtStatusId) {
		this.empAssmtStatusId = empAssmtStatusId;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId, String assmtName, String dtlStatusId, String summary, String createdDate,
			String intervalTypeValue, String status, String lastUpdatedDate, HashMap<String, String> accessors,
			HashMap<String, String> assessees, long assmtDtlRcdId, String assmtDtlStatusId, String assmtOutcome,
			String assmtCompletedDate, String projectName, String assmtComments, long empAssmtRcdId,
			String empAssmtAssignedDate, String empInitId, String empAssmtStatusId) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
		this.assmtName = assmtName;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.intervalTypeValue = intervalTypeValue;
		this.status = status;
		this.lastUpdatedDate = lastUpdatedDate;
		this.accessors = accessors;
		this.assessees = assessees;
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.assmtDtlStatusId = assmtDtlStatusId;
		this.assmtOutcome = assmtOutcome;
		this.assmtCompletedDate = assmtCompletedDate;
		this.projectName = projectName;
		this.assmtComments = assmtComments;
		this.empAssmtRcdId = empAssmtRcdId;
		this.empAssmtAssignedDate = empAssmtAssignedDate;
		this.empInitId = empInitId;
		this.empAssmtStatusId = empAssmtStatusId;
	}

	public HashMap<String, String> getAccessors() {
		return accessors;
	}

	public void setAccessors(HashMap<String, String> accessors) {
		this.accessors = accessors;
	}

	public HashMap<String, String> getAssessees() {
		return assessees;
	}

	public void setAssessees(HashMap<String, String> assessees) {
		this.assessees = assessees;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId, String assmtName, String dtlStatusId, String summary, String createdDate,
			String intervalTypeValue, String status, String lastUpdatedDate, HashMap<String, String> accessors,
			HashMap<String, String> assessees) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
		this.assmtName = assmtName;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.intervalTypeValue = intervalTypeValue;
		this.status = status;
		this.lastUpdatedDate = lastUpdatedDate;
		this.accessors = accessors;
		this.assessees = assessees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId, String assmtName, String dtlStatusId, String summary, String createdDate,
			String intervalTypeValue, String status, String lastUpdatedDate) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
		this.assmtName = assmtName;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.intervalTypeValue = intervalTypeValue;
		this.status = status;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Assessment(String assmtName, String interval, String statusId, String dtlStatusId, String summary,
			String createdDate, String creatorId, String assmtDes, String lastUpdatedDate, String assesseeId,long rcdId) {
		super();
		
		this.assmtName = assmtName;
		this.interval = interval;
		this.statusId = statusId;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.assmtDes = assmtDes;
		this.lastUpdatedDate = lastUpdatedDate;
		this.assesseeId = assesseeId;
		this.rcdId = rcdId;

	}

	public Assessment(long assmtId, String assmtName, String assmtType, String intervalTypeValue, String statusId,
			String status, String dtlStatusId, String summary, String createdDate, String assmtDes,
			String lastUpdatedDate) {
		super();
		this.assmtId = assmtId;
		this.assmtName = assmtName;
		this.assmtType = assmtType;
		this.intervalTypeValue = intervalTypeValue;
		this.statusId = statusId;
		this.status = status;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.assmtDes = assmtDes;
		this.lastUpdatedDate = lastUpdatedDate;

	}

	public String getAssmtName() {
		return assmtName;
	}

	public void setAssmtName(String assmtName) {
		this.assmtName = assmtName;
	}

	public Assessment(long assmtId, String assmtName, String assmtType, String statusId, String dtlStatusId,
			String summary, String createdDate, String intervalTypeValue) {
		super();
		this.assmtId = assmtId;
		this.assmtName = assmtName;
		this.assmtType = assmtType;
		this.statusId = statusId;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.intervalTypeValue = intervalTypeValue;

	}

	public String getDtlStatusId() {
		return dtlStatusId;
	}

	public void setDtlStatusId(String dtlStatusId) {
		this.dtlStatusId = dtlStatusId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getIntervalTypeValue() {
		return intervalTypeValue;
	}

	public void setIntervalTypeValue(String intervalTypeValue) {
		this.intervalTypeValue = intervalTypeValue;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId, String assmtName, String dtlStatusId, String summary, String createdDate,
			String intervalTypeValue) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
		this.assmtName = assmtName;
		this.dtlStatusId = dtlStatusId;
		this.summary = summary;
		this.createdDate = createdDate;
		this.intervalTypeValue = intervalTypeValue;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId, String assmtName) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
		this.assmtName = assmtName;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId, String statusId) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
		this.statusId = statusId;
	}

	public Assessment(long rcdId, long assmtId, String assmtType, List<String> assesseeIds, String initDate,
			String endDate, String assmtDes, List<String> assessors, String interval, boolean staticFlag,
			String projectId) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtType = assmtType;
		this.assesseeIds = assesseeIds;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assmtDes = assmtDes;
		this.assessors = assessors;
		this.interval = interval;
		this.staticFlag = staticFlag;
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Assessment [rcdId=" + rcdId + ", assmtId=" + assmtId + ", assmtType=" + assmtType + ", assesseeIds="
				+ assesseeIds + ", initDate=" + initDate + ", endDate=" + endDate + ", assmtDes=" + assmtDes
				+ ", assessors=" + assessors + ", interval=" + interval + ", staticFlag=" + staticFlag + ", projectId="
				+ projectId + ", statusId=" + statusId + ", assmtName=" + assmtName + ", dtlStatusId=" + dtlStatusId
				+ ", summary=" + summary + ", createdDate=" + createdDate + ", intervalTypeValue=" + intervalTypeValue
				+ ", status=" + status + ", lastUpdatedDate=" + lastUpdatedDate + ", accessors=" + accessors
				+ ", assessees=" + assessees + ", assmtDtlRcdId=" + assmtDtlRcdId + ", assmtDtlStatusId="
				+ assmtDtlStatusId + ", assmtOutcome=" + assmtOutcome + ", assmtCompletedDate=" + assmtCompletedDate
				+ ", projectName=" + projectName + ", assmtComments=" + assmtComments + ", empAssmtRcdId="
				+ empAssmtRcdId + ", empAssmtAssignedDate=" + empAssmtAssignedDate + ", empInitId=" + empInitId
				+ ", empAssmtStatusId=" + empAssmtStatusId + ", assmtCapabilities=" + assmtCapabilities + "]";
	}

	public long getRcdId() {
		return rcdId;
	}

	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}

	public long getAssmtId() {
		return assmtId;
	}

	public void setAssmtId(long assmtId) {
		this.assmtId = assmtId;
	}

	public String getAssmtType() {
		return assmtType;
	}

	public void setAssmtType(String assmtType) {
		this.assmtType = assmtType;
	}

	public List<String> getAssesseeIds() {
		return assesseeIds;
	}

	public void setAssesseeIds(List<String> assesseeIds) {
		this.assesseeIds = assesseeIds;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAssmtDes() {
		return assmtDes;
	}

	public void setAssmtDes(String assmtDes) {
		this.assmtDes = assmtDes;
	}

	public List<String> getAssessors() {
		return assessors;
	}

	public void setAssessors(List<String> assessors) {
		this.assessors = assessors;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public boolean isStaticFlag() {
		return staticFlag;
	}

	public void setStaticFlag(boolean staticFlag) {
		this.staticFlag = staticFlag;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Assessment() {
		super();

	}

}
