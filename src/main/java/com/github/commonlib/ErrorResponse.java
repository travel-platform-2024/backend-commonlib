package com.github.commonlib;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private ErrorCodeDto error;

    public ErrorResponse(ErrorCode errorCode, String errorMessage){
        this.error = ErrorCodeDto.builder()
                .httpStatus(errorCode.getHttpStatus().value())
                .errorCode(errorCode.getErrorCode())
                .errorMessage(errorMessage)
                .build();
    }
}
