package com.gss.pulseworkflow.utility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gss.pulseworkflow.dao.RoleRepository;
import com.gss.pulseworkflow.dao.impl.RoleRepositoryIml;
import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.EmployeeValidation;

public class Validation  {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public HashMap<String,List<Employee>> employeeValidation(List<Employee> employees) {
		List<Employee> processed = new ArrayList<Employee>();
		HashMap<String,List<Employee>> data=new HashMap<String,List<Employee>>();
		try {
			List<Employee> failedRecords = new ArrayList<Employee>();
			
			for (Employee employee : employees) {
				String hireDate=dateFormatTo(employee.getHireDate());
				if (!employee.getEmployeeId().isEmpty() && employee.getEmployeeId() != null
						&& !spclCharValidation(employee.getEmployeeId())) {
					System.out.println("employee id::"+employee.getEmployeeId());
					// employee id
					if (!employee.getFirstName().isEmpty() && employee.getFirstName() != null
							&& !spclCharValidation(employee.getFirstName())) {
						// first Name
						System.out.println("FIRST NAME::"+employee.getFirstName());
						if (!spclCharValidation(employee.getMiddleName())) {
							// middle Name
							System.out.println("MIDDLE NAME::"+employee.getMiddleName());
							if (!employee.getLastName().isEmpty() && employee.getLastName() != null
									&& !spclCharValidation(employee.getLastName())) {
								// Last Name
								System.out.println("LAST NAME::"+employee.getLastName());
								if (domainValidation(employee.getEmailId())) {
									// email id
									System.out.println("EMIAL::"+employee.getEmailId());
									if(mobileNumberValidation(employee.getContactNumber1())) {
										// CONTACT NUMBER 1
										System.out.println("CONTACT1::"+employee.getContactNumber1());
										if(mobileNumberValidation(employee.getContactNumber2())) {
											// CONTACT NUMBER 2
											System.out.println("CONTACT2::"+employee.getContactNumber2());
											if(dateValication(hireDate)) {
												// CONTACT NUMBER 2
												System.out.println("HireDate::"+employee.getHireDate());
												if(addressValidation(employee.getAddressType(),employee.getAddress1(),employee.getAddress2())) {
													System.out.println("addressvalidation::"+employee.getAddressType()+employee.getAddress1()+employee.getAddress2());
													if(managerIDEmailVali(employee.getManagerId(),employee.getManagerEmail())) {
														System.out.println("managerid email::"+employee.getManagerId()+employee.getManagerEmail());
														//if (!employee.getManagerFirstName().isEmpty() && employee.getManagerFirstName() != null
																//&& !spclCharValidation(employee.getManagerFirstName().trim())) {
															//if (!employee.getManagerLastName().isEmpty() && employee.getManagerLastName() != null
																	//&& !spclCharValidation(employee.getManagerLastName().trim())) {
																if(positionVali(employee.getPositionLevel())) {
																	/*
																	 * if(ctcVali(employee.getCostTOCompany())) {
																	 * processed.add(employee); }else {
																	 * failedRecords.add(employee); }
																	 */
																	processed.add(employee);
																}else {
																	failedRecords.add(employee);
																}
																
															//}else {
																//failedRecords.add(employee);
															//}
															
														//}else {
															//failedRecords.add(employee);
														//}
														
														
													}else {
														failedRecords.add(employee);
														System.out.println("managerid email:: ELSE"+employee.getManagerId()+employee.getManagerEmail());
													}
												}else {
													failedRecords.add(employee);
													System.out.println("addressvalidation:: ELSE"+employee.getAddressType()+employee.getAddress1()+employee.getAddress2());
												}
												
											} else {
												failedRecords.add(employee);
												System.out.println("HireDate::ELSE"+employee.getHireDate());
											}
											
										} else {
											failedRecords.add(employee);
											System.out.println("CONTACT2::ELSE"+employee.getContactNumber2());
										}
									} else {
										failedRecords.add(employee);
										System.out.println("CONTACT1::ELSE"+employee.getContactNumber1());
									}
								} else {
									failedRecords.add(employee);
									System.out.println("EMIAL::ELSE"+employee.getEmailId());
								}

							} else {
								failedRecords.add(employee);
								System.out.println("LAST NAME::ELSE"+employee.getLastName());
							}

						} else {
							failedRecords.add(employee);
							System.out.println("MIDDLE NAME::ELSE"+employee.getMiddleName());
						}

					} else {
						failedRecords.add(employee);
						System.out.println("FIRST NAME::ELSE"+employee.getFirstName());
					}

				} else {
					System.out.println("employee id::ELSE"+employee.getEmployeeId());
					failedRecords.add(employee);
				}
				if(employee.getEmployeeStatus()==null  || employee.getEmployeeStatus().isEmpty()) {
					employee.setEmployeeStatus("0");
				}else if(employee.getEmployeeStatus().equalsIgnoreCase("Active")) {
					employee.setEmployeeStatus("0");
				}else if(employee.getEmployeeStatus().equalsIgnoreCase("Disable")) {
					employee.setEmployeeStatus("1");
				}
				
			}
			data.put("Process", processed);
			data.put("Failed", failedRecords);
			System.out.println("failed: "+failedRecords);
			//save(failedRecords);
			System.out.println("processes: "+processed);
			}catch(Exception e){
				System.out.println(e);
			}
		return data;

	}
	private long getPositionIdByName(String positionName) {
		
		return 0;
		
	}

	public void writingTOReport(List<Employee> processedUsers,List<EmployeeValidation> managerKeyValidationFaild) throws InvalidFormatException, IOException {
		List<EmployeeValidation> validationListForReport = new ArrayList<>();
		ExcelWriter writer=new ExcelWriter();
		for (Employee employee : processedUsers) {
			boolean empIdFlag = false;
			boolean firstNameFlag = false;
			boolean middleNameFlag = false;
			boolean lastNameFlag = false;
			boolean emailIdFlag = false;
			boolean contactNU1Flag = false;
			boolean contactNU2Flag = false;
			boolean addressFlag = false;
			boolean managerEmailORIDFlag = false;
			boolean positionLevelFlag = false;
			boolean hireDateFlag=false;
			//boolean ctcFlag = false;
			String hireDate=dateFormatTo(employee.getHireDate());
			if (!employee.getEmployeeId().isEmpty() && employee.getEmployeeId() != null
					&& !spclCharValidation(employee.getEmployeeId())) {
				empIdFlag = true;
				System.out.println("employee id::" + employee.getEmployeeId());
				// employee id
			}
			if (!employee.getFirstName().isEmpty() && employee.getFirstName() != null
					&& !spclCharValidation(employee.getFirstName())) {
				// first Name
				firstNameFlag = true;
				System.out.println("FIRST NAME::" + employee.getFirstName());
			}
			if (!spclCharValidation(employee.getMiddleName())) {
				// middle Name
				middleNameFlag = true;
				System.out.println("MIDDLE NAME::" + employee.getMiddleName());
			}
			if (!employee.getLastName().isEmpty() && employee.getLastName() != null
					&& !spclCharValidation(employee.getLastName())) {
				// Last Name
				lastNameFlag = true;
				System.out.println("LAST NAME::" + employee.getLastName());
			}
			if (domainValidation(employee.getEmailId())) {
				// email id
				emailIdFlag = true;
				System.out.println("EMIAL::" + employee.getEmailId());
			}
			if (mobileNumberValidation(employee.getContactNumber1())) {
				// CONTACT NUMBER 1
				contactNU1Flag = true;
				System.out.println("CONTACT1::" + employee.getContactNumber1());
			}
			if (mobileNumberValidation(employee.getContactNumber2())) {
				// CONTACT NUMBER 2
				contactNU2Flag = true;
				System.out.println("CONTACT2::" + employee.getContactNumber2());
			}
			if (dateValication(hireDate)) {
				// CONTACT NUMBER 2
				hireDateFlag=true;
				System.out.println("HireDate::" + employee.getHireDate());
			}
			if (addressValidation(employee.getAddressType(), employee.getAddress1(), employee.getAddress2())) {
				addressFlag = true;
				System.out.println("addressvalidation::" + employee.getAddressType() + employee.getAddress1()
						+ employee.getAddress2());
			}
			if (managerIDEmailVali(employee.getManagerId(), employee.getManagerEmail())) {
				managerEmailORIDFlag = true;
				System.out.println("managerid email::" + employee.getManagerId() + employee.getManagerEmail());
			}
			// if (!employee.getManagerFirstName().isEmpty() &&
			// employee.getManagerFirstName() != null
			// && !spclCharValidation(employee.getManagerFirstName().trim())) {
			// if (!employee.getManagerLastName().isEmpty() && employee.getManagerLastName()
			// != null
			// && !spclCharValidation(employee.getManagerLastName().trim())) {
			if (positionVali(employee.getPositionLevel())) {
				positionLevelFlag = true;
			}
			/*
			 * if (ctcVali(employee.getCostTOCompany())) { ctcFlag = true; }
			 */
			EmployeeValidation validationObj = new EmployeeValidation();

			int validationFailedCOunt = 0;
			String validation = "";
			boolean flag=false;
			if (!empIdFlag) {
				validation = validation + "Invalid EmployeeId";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!firstNameFlag && !flag) {
				validation = validation + "Invalid First Name";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!firstNameFlag && flag) {
				validation = validation + " \n Invalid First Name";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!middleNameFlag && !flag) {
				validation = validation + "Invalid Middle Name";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!middleNameFlag && flag) {
				validation = validation + " \n Invalid Middle Name";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!lastNameFlag && !flag) {
				validation = validation + "Invalid Last Name";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!lastNameFlag && flag) {
				validation = validation + " \\n Invalid Last Name";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!emailIdFlag && !flag) {
				validation = validation + "Invalid Email";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!emailIdFlag && flag) {
				validation = validation + " \n Invalid Email";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!contactNU1Flag && !flag) {
				validation = validation + "Invalid Contact Nummber1";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!contactNU1Flag && flag) {
				validation = validation + " \n Invalid Contact Nummber1";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!contactNU2Flag && !flag) {
				validation = validation + "Invalid Contact Number2";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!contactNU2Flag && flag) {
				validation = validation + " \n Invalid Contact Number2";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!addressFlag && !flag) {
				validation = validation + "Invalid AddressType/Address1/Address2";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!addressFlag && flag) {
				validation = validation + " \n Invalid AddressType/Address1/Address2";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!managerEmailORIDFlag && !flag) {
				validation = validation + "Invalid Manager Id/Email";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!managerEmailORIDFlag && flag) {
				validation = validation + " \n Invalid Manager Id/Email";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!positionLevelFlag && !flag) {
				validation = validation + "Invalid Position Level";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!positionLevelFlag && flag) {
				validation = validation + " \n Invalid Position Level";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			if (!hireDateFlag && !flag) {
				validation = validation + "Invalid Hire Date";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}else if (!hireDateFlag && flag) {
				validation = validation + " \n Invalid Hire Date";
				validationFailedCOunt = validationFailedCOunt + 1;
				flag=true;
			}
			/*hireDateFlag
			 * if (!ctcFlag && !flag) { validation = validation + "Invalid CTC";
			 * validationFailedCOunt = validationFailedCOunt + 1; flag=true; }else if
			 * (!ctcFlag && flag) { validation = validation + " \n Invalid CTC";
			 * validationFailedCOunt = validationFailedCOunt + 1; flag=true; }
			 */
			validationObj.setEmployeeDetails(employee);
			validationObj.setNumberOfValidationsFailed(validationFailedCOunt);
			validationObj.setValidationComments(validation);
			validationListForReport.add(validationObj);
		}
		validationListForReport.addAll(managerKeyValidationFaild);
		writer.writeDataToExcel(validationListForReport);
	}
																	
	public static boolean spclCharValidation(String Value) {
		Matcher matcher = null;
		try {
			if(Value== null || Value.isEmpty()) {
				return false;
			}else {
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
			matcher = pattern.matcher(Value);
			
			}
		} catch (Exception e) {
		}
		 return matcher.find();
	}

	public static boolean domainValidation(String emailID) {
		boolean statusRes = false;
		//List<String> domains = new ArrayList<String>();
		//domains.add("@gssinfotech.com");
		//domains.add("@gss.com");
		//domains.add("@demo.com");
		//domains.add("@spider-technology.com");
		//domains.add("@spider.com");
		if (!emailID.isEmpty() && emailID != null) {
			//for (String domain : domains) {
				if (emailID.contains("@")) {
					statusRes = true;
				}
			//}
		}
		return statusRes;

	}

	public static boolean mobileNumberValidation(String mobileNumber) {
		Matcher matcher = null;
		try {
			if(mobileNumber.isEmpty()) {
				return true;
			}else {
			//String[] contactArray=mobileNumber.split("\\)");
			//if(contactArray.length==2) {
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			matcher = pattern.matcher(mobileNumber);
			//if(mobileIndex(contactArray[0])) {
				return matcher.matches();
			//}
			//}else {
				//return false;
			//}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return false;
		

	}
	
	
	
	/*
	 * public static void main(String args[]) { List<Employee> list=new
	 * ArrayList<Employee>(); try{
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Class.forName("com.mysql.jdbc.Driver"); Connection
	 * con=DriverManager.getConnection(
	 * "jdbc:mysql://142.4.9.16:3306/pulse?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
	 * ,"pulse","G$$1nfot3ch"); //here sonoo is database name, root is username
	 * Statement stmt=con.createStatement(); ResultSet
	 * rs=stmt.executeQuery("select * from EMP_DETAIL_TEMP"); while(rs.next()) {
	 * Employee emp=new Employee(); emp.setEmployeeId(rs.getString("EMPLOYEE_ID"));
	 * emp.setFirstName(rs.getString("FIRST_NAME"));
	 * emp.setMiddleName(rs.getString("MIDDLE_NAME"));
	 * emp.setLastName(rs.getString("LAST_NAME"));
	 * emp.setEmailId(rs.getString("EMAIL"));
	 * emp.setAddress1(rs.getString("ADDRESS_LINE_1"));
	 * emp.setAddress2(rs.getString("ADDRESS_LINE_2"));
	 * emp.setZipcode(rs.getString("ZIP_CODE")); emp.setCity(rs.getString("CITY"));
	 * emp.setState(rs.getString("STATE")); emp.setCountry(rs.getString("COUNTRY"));
	 * emp.setAddressType(rs.getString("ADDRESS_TYPE"));
	 * emp.setContactNumber1(rs.getString("CONTACT_NUMBER_1"));
	 * emp.setContactNumber2(rs.getString("CONTACT_NUMBER_2"));
	 * emp.setHireDate(rs.getString("HIRE_DATE"));
	 * emp.setPosition(rs.getString("POSITION"));
	 * emp.setPositionLevel(rs.getString("POSITION_LEVEL"));
	 * emp.setCostTOCompany(rs.getString("COST_TO_COMPANY"));
	 * emp.setCtcCurrency(rs.getString("CTC_CURRENCY"));
	 * emp.setCommissionPCT(rs.getString("COMMISSION_PCT"));
	 * emp.setManagerId(rs.getString("MANAGER_ID"));
	 * emp.setManagerEmail(rs.getString("MANAGER_EMAIL"));
	 * emp.setDepartmentId(rs.getString("DEPARTMENT_ID"));
	 * emp.setDepartment(rs.getString("DEPARTMENT"));
	 * emp.setLastWorkingDate(rs.getString("LAST_WORKING_DATE"));
	 * emp.setEmployeeStatus(rs.getString("EMPLOYMENT_STATUS"));
	 * emp.setEmploymentType(rs.getString("EMPLOYMENT_TYPE")); emp.
	 * setOrganizationId(rs.getString("ORGANIZATION_ID"));
	 * emp.setOrganization(rs.getString("ORGANIZATION"));
	 * emp.setManagerFirstName(rs.getString("MANAGAR_FIRSTNAME"));
	 * emp.setManagerMiddleName(rs.getString("MANAGAR_MIDDLENAME"));
	 * emp.setManagerLastName(rs.getString("MANAGAR_LASTNAME")); list.add(emp);
	 * //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	 * //con.close();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //String contact=""; //String concat2="07/04/2019"; //String concat3="xyz";
	 * //String[] contactArray=contact.split("\\)");
	 * 
	 * //System.out.println("CONTACT ARRAY::"+contactArray[0]+" :: "+contactArray[1]
	 * ); //boolean indexFlag=mobileIndex(contactArray[0]);
	 * //System.out.println("indexFlag::"+indexFlag); //boolean
	 * data=ctcVali(concat2); //boolean data=dateValication(concat2);
	 * //System.out.println("data::"+data); }catch(Exception e){
	 * System.out.println(e); } //List<Employee> finalList=employeeValidation(list);
	 * //System.out.println(finalList); }
	 */

		//List<Employee> dataFromStaging=employeeRepository.findAll();
	// @formatter:on
	public static boolean mobileIndex(String mobileIndex) {
		boolean statusRes = false;
		List<String> index = new ArrayList<String>();
		index.add("+(91");
		index.add("+(1");
		
		if (!mobileIndex.isEmpty() && mobileIndex != null) {
			for (String domain : index) {
				if (mobileIndex.contains(domain)) {
					statusRes = true;
					break;
				}
			}
		}
		return statusRes;

	}
	
	
	private static final java.text.SimpleDateFormat dateFormat = 
		    new java.text.SimpleDateFormat("yyyy-MM-dd");

		public static boolean dateValication(String date) {
		  if (date != null && !date.isEmpty()) {
		    try {
		      java.util.Date ret = dateFormat.parse(date.trim());
		      if (dateFormat.format(ret).equals(date.trim())) {
		        return true;
		      }
		    } catch (ParseException e) {
		      return false;
		    }
		  }
		  return false;
		}
		 
		public static boolean addressValidation(String addressType,String address1,String address2) {
			
			try {
				if(addressType.isEmpty() || addressType==null) {
					return true;
				}else if(!addressType.isEmpty() || addressType!=null) {
					if((!address1.isEmpty() && address1!=null) || (!address2.isEmpty() && address2!=null)) {
						return true;
						}
					}
			} catch (Exception e) {
			      e.printStackTrace();
			    }
			return false;
			
		}
		
		public static boolean managerIDEmailVali(String managerId,String managerEmail) {
			boolean flag=false;
			boolean flag2=false;
			try {
				if((!managerId.isEmpty() && managerId!=null) || (!managerEmail.isEmpty() && managerEmail!=null)) {
					if(!spclCharValidation(managerId.trim()) && !managerId.isEmpty() && managerId!=null) {
						flag =true;
						//return true;
					} 
					if(domainValidation(managerEmail.trim()) && !managerEmail.isEmpty() && managerEmail!=null) {
						flag2=true;
					}
					if(flag || flag2) {
						return true;
					}
				}
			}catch (Exception e) {
			      e.printStackTrace();
			    }
			return flag;
			
		}
		
		public static boolean positionVali(String position) {
			try {
			if(position.isEmpty()) {
				return true;
			}else {
				Integer.parseInt(position.trim());
				return true;
			}
		}catch (Exception e) {
		      return false;
		    }
			
		}
		public static boolean ctcVali(String ctc) {
			try {
			if(!ctc.isEmpty()) {
				Integer.parseInt(ctc.trim());
				return true;
			}
		}catch (Exception e) {
		      return false;
		    }
			return false;
			
		}
		

		public static void main(String args[]) {
			
			  

			 // public static void main(String[] args) {
			    //System.out.println(dateFormatTo("9/10/2013"));
			 // }
		}
		public String dateFormatTo(String inDate) {
			SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
			SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
		    String outDate = "";
		    if (inDate != null) {
		        try {
		            Date date = inSDF.parse(inDate);
		            outDate = outSDF.format(date);
		        } catch (ParseException ex){ 
		        }
		    }
		    return outDate;
		  }

		/*
		 * @Override public int save(Users users) { // TODO Auto-generated method stub
		 * return 0; }
		 */
		

}
