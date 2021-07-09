package com.gss.pulseworkflow.model;

import java.util.List;

public class Employee {
	private long rcdId;
	private String employeeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String address1;
	private String address2;
	private String zipcode;
	private String city;
	public long getRcdId() {
		return rcdId;
	}

	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}

	private String state;
	private String country;
	private String addressType;
	private String contactNumber1;
	private String contactNumber2;
	private String hireDate;
	private String position;
	private String positionLevel;
	private String costTOCompany;
	private String ctcCurrency;
	private String commissionPCT;
	private String managerId;
	private String managerEmail;
	private String department;
	private String departmentId;
	private String lastWorkingDate;
	private String employeeStatus;
	private String employmentType;
	private String organization;
	private String organizationId;
	private String managerFirstName;
	private String managerMiddleName;
	private String managerLastName;
	private String employeeStatusValue;
	private String positionName;
	
	private List<UserSkills> userSkills;
	private String avgRating;
	private List<Utilization> utilization;
	public List<UserSkills> getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(List<UserSkills> userSkills) {
		this.userSkills = userSkills;
	}
	public String getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}
	public List<Utilization> getUtilization() {
		return utilization;
	}
	public void setUtilization(List<Utilization> utilization) {
		this.utilization = utilization;
	}
	
	

	public String getEmployeeStatusValue() {
		return employeeStatusValue;
	}

	public void setEmployeeStatusValue(String employeeStatusValue) {
		this.employeeStatusValue = employeeStatusValue;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", address1=" + address1 + ", address2="
				+ address2 + ", zipcode=" + zipcode + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", addressType=" + addressType + ", contactNumber1=" + contactNumber1 + ", contactNumber2="
				+ contactNumber2 + ", hireDate=" + hireDate + ", position=" + position + ", positionLevel="
				+ positionLevel + ", costTOCompany=" + costTOCompany + ", ctcCurrency=" + ctcCurrency
				+ ", commissionPCT=" + commissionPCT + ", managerId=" + managerId + ", managerEmail=" + managerEmail
				+ ", department=" + department + ", departmentId=" + departmentId + ", lastWorkingDate="
				+ lastWorkingDate + ", employeeStatus=" + employeeStatus + ", employmentType=" + employmentType
				+ ", organization=" + organization + ", organizationId=" + organizationId + ", managerFirstName="
				+ managerFirstName + ", managerMiddleName=" + managerMiddleName + ", managerLastName=" + managerLastName
				+ "]";
	}
	
			
			public Employee(long rcdId,String employeeId, String firstName, String middleName, String lastName, String emailId,
					String address1, String address2, String zipcode, String city, String state, String country,
					String addressType, String contactNumber1, String contactNumber2, String hireDate, String position,String positionName,
					String positionLevel, String costTOCompany, String ctcCurrency, String commissionPCT, String managerId,
					String managerEmail, String departmentId,String department,  String employeeStatus,String employeeStatusValue,
					String employmentType) {
				super();
				this.rcdId=rcdId;
				this.employeeId = employeeId;
				this.firstName = firstName;
				this.middleName = middleName;
				this.lastName = lastName;
				this.emailId = emailId;
				this.address1 = address1;
				this.address2 = address2;
				this.zipcode = zipcode;
				this.city = city;
				this.state = state;
				this.country = country;
				this.addressType = addressType;
				this.contactNumber1 = contactNumber1;
				this.contactNumber2 = contactNumber2;
				this.hireDate = hireDate;
				this.position = position;
				this.positionName = positionName;
				this.positionLevel = positionLevel;
				this.costTOCompany = costTOCompany;
				this.ctcCurrency = ctcCurrency;
				this.commissionPCT = commissionPCT;
				this.managerId = managerId;
				this.managerEmail = managerEmail;
				this.department = department;
				this.departmentId = departmentId;
				
				this.employeeStatus = employeeStatus;
				this.employeeStatusValue = employeeStatusValue;
				this.employmentType = employmentType;
				
				
			}

	public Employee(String employeeId, String firstName, String middleName, String lastName, String emailId,
			String address1, String address2, String zipcode, String city, String state, String country,
			String addressType, String contactNumber1, String contactNumber2, String hireDate, String position,
			String positionLevel, String costTOCompany, String ctcCurrency, String commissionPCT, String managerId,
			String managerEmail, String department, String departmentId, String lastWorkingDate, String employeeStatus,
			String employmentType, String organization, String organizationId, String managerFirstName,
			String managerMiddleName, String managerLastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.addressType = addressType;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.hireDate = hireDate;
		this.position = position;
		this.positionLevel = positionLevel;
		this.costTOCompany = costTOCompany;
		this.ctcCurrency = ctcCurrency;
		this.commissionPCT = commissionPCT;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.department = department;
		this.departmentId = departmentId;
		this.lastWorkingDate = lastWorkingDate;
		this.employeeStatus = employeeStatus;
		this.employmentType = employmentType;
		this.organization = organization;
		this.organizationId = organizationId;
		this.managerFirstName = managerFirstName;
		this.managerMiddleName = managerMiddleName;
		this.managerLastName = managerLastName;
	}
	
	public Employee(String employeeId, String firstName, String middleName, String lastName, String emailId,
			String address1, String address2, String zipcode, String city, String state, String country,
			String addressType, String contactNumber1, String contactNumber2, String hireDate, String position,
			String positionLevel, String costTOCompany, String ctcCurrency, String commissionPCT, String managerId,
			String managerEmail, String department, String departmentId, String lastWorkingDate, String employeeStatus,
			String employmentType, String organization, String organizationId, String managerFirstName,
			String managerMiddleName, String managerLastName,long rcdId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.addressType = addressType;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.hireDate = hireDate;
		this.position = position;
		this.positionLevel = positionLevel;
		this.costTOCompany = costTOCompany;
		this.ctcCurrency = ctcCurrency;
		this.commissionPCT = commissionPCT;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.department = department;
		this.departmentId = departmentId;
		this.lastWorkingDate = lastWorkingDate;
		this.employeeStatus = employeeStatus;
		this.employmentType = employmentType;
		this.organization = organization;
		this.organizationId = organizationId;
		this.managerFirstName = managerFirstName;
		this.managerMiddleName = managerMiddleName;
		this.managerLastName = managerLastName;
		this.rcdId=rcdId;
	}
	

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositionLevel() {
		return positionLevel;
	}

	public void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}

	public String getCostTOCompany() {
		return costTOCompany;
	}

	public void setCostTOCompany(String costTOCompany) {
		this.costTOCompany = costTOCompany;
	}

	public String getCtcCurrency() {
		return ctcCurrency;
	}

	public void setCtcCurrency(String ctcCurrency) {
		this.ctcCurrency = ctcCurrency;
	}

	public String getCommissionPCT() {
		return commissionPCT;
	}

	public void setCommissionPCT(String commissionPCT) {
		this.commissionPCT = commissionPCT;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getLastWorkingDate() {
		return lastWorkingDate;
	}

	public void setLastWorkingDate(String lastWorkingDate) {
		this.lastWorkingDate = lastWorkingDate;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Employee() {
		super();
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerMiddleName() {
		return managerMiddleName;
	}

	public void setManagerMiddleName(String managerMiddleName) {
		this.managerMiddleName = managerMiddleName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}
}
