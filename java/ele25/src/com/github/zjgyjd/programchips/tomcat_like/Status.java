package com.github.zjgyjd.programchips.tomcat_like;

public enum Status {
    OK(200 , "OK"),
    BAD_REQUEST(400 , "Bad Request"),
    NOT_FOUND(404 , "Not Found"),
    INTERNAL_SERVER_ERROR(500 , "Internal Server Error");

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    private int code;
    private String reason;

    Status(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }
}
