package com.activityFlow.vo;


/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description
 */
public class ResponseResultVo<T> {
    private T result;
    private Integer code;
    private String msg;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseResultVo() {
    }

    public ResponseResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResultVo(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

}
