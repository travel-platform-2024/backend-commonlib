package com.github.commonlib;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorCodeDto {
    private int httpStatus;

    private String errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
}
