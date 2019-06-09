package com.messageanalytics.service.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class CustomResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success = true;
    private String message;
    private Object data;
    private String errorCode;
    private HttpStatus httpStatus;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
