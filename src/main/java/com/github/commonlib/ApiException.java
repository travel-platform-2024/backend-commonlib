package com.github.commonlib;

public class ApiException extends RuntimeException{
    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }
}
