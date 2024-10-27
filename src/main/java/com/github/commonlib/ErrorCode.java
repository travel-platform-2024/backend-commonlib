package com.github.commonlib;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    //400
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"E40001","BAD_REQUEST"),

    //401
    LOGIN_FAIL(HttpStatus.UNAUTHORIZED,"E40101","LOGIN_FAIL"),
    INVALID_ACCESSTOKEN(HttpStatus.UNAUTHORIZED, "E40102","INVALID_ACCESSTOKEN"),
    INVALID_REFRESHTOKEN(HttpStatus.UNAUTHORIZED, "E40103","INVALID_REFRESHTOKEN"),

    //403
    FORBIDDEN(HttpStatus.FORBIDDEN,"E40301", "FORBIDDEN"),

    //409
    EMAIL_CONFLICT(HttpStatus.CONFLICT, "E40002", "EMAIL_CONFLICT");

    private HttpStatus httpStatus;
    private String errorCode;
    private String errorMessage;


    ErrorCode(HttpStatus httpStatus, String errorCode,String errorMessage){
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
