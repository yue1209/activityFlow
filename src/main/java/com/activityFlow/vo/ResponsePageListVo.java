package com.activityFlow.vo;

import java.util.List;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description
 */
public class ResponsePageListVo<T> {
    private List<T> results;
    private Integer total;
    private Integer code;
    private String msg;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public ResponsePageListVo() {
    }

    public ResponsePageListVo(Integer code, String msg, Integer total) {
        this.code = code;
        this.msg = msg;
        this.total = total;
    }

    public ResponsePageListVo(Integer code, String msg, Integer total, List<T> results) {
        this.code = code;
        this.msg = msg;
        this.total = total;
        this.results = results;
    }
}
