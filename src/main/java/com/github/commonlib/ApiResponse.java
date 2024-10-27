package com.github.commonlib;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorResponse error;

    private ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    private ApiResponse(ErrorCode errorCode) {

        this.error = ErrorCode.getErrorResponse(errorCode);
    }

    private ApiResponse(ErrorCode errorCode, String message) {
        this.error = ErrorCode.getErrorResponse(errorCode);
        this.error.setErrorMessage(message);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, message);
    }


    public static <T> ApiResponse<T> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode, message);
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode);
    }
}
