package com.example.exception;

/**
 * 自定义的异常
 *
 * @author zhoupeng
 * @create time 2021-04-15-16:29
 */
public class MyException extends RuntimeException{
    private String code;
    private String message;

    public MyException(String code,String message) {
        this.code = code;
        this.message = message;
    }
    public static void throwMyException(String code, String message) {
        throw new MyException(code,message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
