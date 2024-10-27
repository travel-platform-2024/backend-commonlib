package com.github.commonlib;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@Getter
public enum ErrorCode {
    //400
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"E40001"),

    //401
    LOGIN_FAIL(HttpStatus.UNAUTHORIZED,"E40101"),
    INVALID_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "E40102"),
    INVALID_JWT_SIGNATURE(HttpStatus.UNAUTHORIZED, "E40103"),

    //403
    FORBIDDEN(HttpStatus.FORBIDDEN,"E40301"),

    //409
    EMAIL_CONFLICT(HttpStatus.CONFLICT, "E40901");

    private HttpStatus httpStatus;
    private String errorCode;



    ErrorCode(HttpStatus httpStatus, String errorCode){
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public static ErrorResponse getErrorResponse(ErrorCode errorCode) {
       return ErrorResponse.builder()
               .httpStatus(errorCode.getHttpStatus().value())
               .errorCode(errorCode.getErrorCode())
               .build();
    }
}
