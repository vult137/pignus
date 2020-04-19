package com.vult.pignus.common.enums;

public enum ResultCode {
    SUCCESS(200, "success"),

    /* 默认失败 */
    COMMON_FAIL(999, "fail"),

    /* 参数错误：1000～1999 */
    PARAM_NOT_VALID(1001, "parameter invalid "),
    PARAM_IS_BLANK(1002, "parameter blank"),
    PARAM_TYPE_ERROR(1003, "parameter type wrong"),
    PARAM_NOT_COMPLETE(1004, "parameter not complete"),

    /* 用户错误 */
    USER_NOT_LOGIN(2001, "user not login"),
    USER_ACCOUNT_EXPIRED(2002, "account expired"),
    USER_CREDENTIALS_ERROR(2003, "password wrong"),
    USER_CREDENTIALS_EXPIRED(2004, "password expired"),
    USER_ACCOUNT_DISABLE(2005, "account disable"),
    USER_ACCOUNT_LOCKED(2006, "account locked"),
    USER_ACCOUNT_NOT_EXIST(2007, "account not exist"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "account already exist"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "account login somewhere else"),

    /* 业务错误 */
    NO_PERMISSION(3001, "no permission");
    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessageByCode(Integer code) {
        for (ResultCode ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }
}
