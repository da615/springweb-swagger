package com.adam.exception;

public enum  ErrorType {
    /**
     * 错误类型
     */
    OBJECT_NOT_FOUND(0,"对象不存在"),

    INVALID_PARAMS(1,"参数不正确"),

    result_not_exist(2,"记录不存在")

    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ErrorType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}