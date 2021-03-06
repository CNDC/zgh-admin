package com.uintell.demo.exception;


public class ServiceException extends Exception {

    private static final long serialVersionUID = -3172803700995059492L;
    private String errorCode;
    private String errorMessage;

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

    public ServiceException() {
        super();
        this.errorCode = "400";
        this.errorMessage = "系统异常，请稍后再试！";
    }

    public ServiceException(String errorMessage) {
        super("Error Message: " + errorMessage);
        this.errorCode = "400";
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorCode, String errorMessage) {
        super("Error Code: " + errorCode + " Error Message: " + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorCode, Exception e) {
        super("Error Code:" + errorCode, e);
        this.errorCode = errorCode;
        this.errorMessage = e.getMessage();
    }

    public ServiceException(String errorCode, String errorMessage, Exception e) {
        super("Error Code: " + errorCode + " : Error Message :" + errorMessage, e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
