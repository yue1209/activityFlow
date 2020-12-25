package com.activityFlow.Exception;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description
 */
public enum ErrorCode {
    UNKNOWN("10000", "未知错误"),
    PARAM_IS_NULL("20000", "参数为空"),
    PARAM_TOKEN_EXPIRE("20003", "token失效");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(String code) {
        for (ErrorCode er : ErrorCode.values()) {
            if (er.code.equals(code)) {
                return er.message;
            }
        }
        return null;
    }

    public static String getCodeByMessage(String message) {
        for (ErrorCode er : ErrorCode.values()) {
            if (er.message.equals(message)) {
                return er.code;
            }
        }
        return null;
    }
}
