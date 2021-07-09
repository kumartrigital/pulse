/**
 * 
 */
package com.gss.pulseworkflow.response;

/**
 * @author SAURABH
 *
 */
public class ResponseWrapper<T> {
    private String status;
    private String errorCode;
    private String errorMessage;
    private String exceptionType;
    private T result;
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
    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }
  
    
    
}
