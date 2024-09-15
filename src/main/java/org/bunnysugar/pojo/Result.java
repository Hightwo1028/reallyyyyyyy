package org.bunnysugar.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // 只序列化非空的屬性
public class Result<T> {
    private String message;
    private T data;
    private boolean success;

    public Result(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data, "成功", true);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(null, message, false);
    }
}
