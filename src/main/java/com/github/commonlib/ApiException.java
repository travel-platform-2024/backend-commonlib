package com.github.commonlib;


import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorMessage;

    public ApiException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public ApiException(ErrorCode errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
