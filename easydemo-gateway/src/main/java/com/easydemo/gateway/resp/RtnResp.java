package com.easydemo.gateway.resp;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
public class RtnResp {

    private Integer code = 200;

    private Object data;

    private String error;

    public static RtnResp success(Object data) {
        RtnResp resp = new RtnResp();
        resp.setData(data);
        return resp;
    }

    public static RtnResp failure(String error) {
        RtnResp resp = new RtnResp();
        resp.setCode(500);
        resp.setError(error);
        return resp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
