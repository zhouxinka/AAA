package com.example.entity;

/**
 * @author zhoupeng
 * @create time 2021-09-07-15:56
 */
public class Result<T> {
    private String code;
    private String message;
    private T data;
    public static <T> Result<T> ok(String code, String msg, T data) {
        Result<T> result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }



    public static <T> Result<T> error(String code, String msg) {
        Result<T> result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData((T) "");
        return result;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
