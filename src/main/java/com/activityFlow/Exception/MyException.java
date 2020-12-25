package com.activityFlow.Exception;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description 自定义异常
 */
public class MyException extends Exception {

    public MyException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
