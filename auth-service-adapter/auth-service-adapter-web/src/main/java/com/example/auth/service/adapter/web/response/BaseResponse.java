package com.example.auth.service.adapter.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse<T> {

    private Result result;
    private T body;

    public static <T> BaseResponse<T> success(T body) {
        return new BaseResponse<>(new Result("0000", "ok"), body);
    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<>(new Result("0000", "ok"), null);
    }


    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Result {

        private String code;
        private String message;

        public Result(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}