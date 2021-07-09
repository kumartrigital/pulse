package com.gss.pulseworkflow.constants;


public class PulseWorkForceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
	   
	   public PulseWorkForceException(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }
	   
	   public String getExceptionMsg(){
	      return this.exceptionMsg;
	   }
	   
	
	}