package com.gss.pulseworkflow.response;

import com.gss.pulseworkflow.constants.AppConstants;

public class Response {
	private String status;
	private String errorCode;
	private String errorMessage;
	private String exceptionType;
	private Object result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public Response() {
		this.status = AppConstants.STATUS_SUCCESS;
	}
	
	/*
	 * public Response(Object result) { ObjectMapper mapper = new ObjectMapper();
	 * 
	 * mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	 * mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	 * mapper.setDateFormat(df); this.status = AppConstants.STATUS_SUCCESS; try {
	 * 
	 * this.result = mapper.writeValueAsString(result); JSONParser parser = new
	 * JSONParser(); try { this.result = parser.parse((String) this.result); } catch
	 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * } } catch (JsonProcessingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	/**
	 * Constructor
	 * 
	 * @param result
	 * @param status
	 */
	public Response(Object result, String status) {
		this.status = status;
		this.result = result;
	}
	public Response(Object result) {
		this.result = result;
	}
	/**
	 * Constructor
	 * 
	 * @param status
	 * @param errorCode
	 * @param errorMessage
	 * @param exceptionType
	 */
	public Response(String status, String errorCode, String errorMessage,
			String exceptionType) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exceptionType = exceptionType;
	}

	/**
	 * Constructor
	 * 
	 * @param status
	 * @param errorCode
	 * @param errorMessage
	 * @param exceptionType
	 */
	public Response(String status, String errorCode, String errorMessage) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}
}
