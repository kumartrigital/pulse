package com.gss.pulseworkflow.exception;

public class PulseWorkFlowException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String exceptionMsg;

	public PulseWorkFlowException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

}
