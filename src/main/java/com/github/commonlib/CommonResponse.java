package com.github.commonlib;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private CommonResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(data, null);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>(data, message);
    }
}
