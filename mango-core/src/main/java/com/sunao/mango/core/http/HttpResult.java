package com.sunao.mango.core.http;

/**
 * HttpResult HTTP结果封装
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/06
 */
public class HttpResult {
    /**
     * 错误码
     */
    private int code = 200;
    /**
     * 错误消息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    /**
     * 请求错误
     *
     * @return 请求结果
     */
    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    /**
     * 请求错误
     *
     * @param msg 错误消息
     * @return 请求结果
     */
    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 请求错误
     *
     * @param code 错误代码
     * @param msg  错误消息
     * @return 请求结果
     */
    public static HttpResult error(int code, String msg) {
        HttpResult result = new HttpResult();
        result.setCode(code).setMsg(msg);
        return result;
    }

    /**
     * 请求OK
     *
     * @param msg 消息
     * @return 请求结果
     */
    public static HttpResult ok(String msg) {
        HttpResult result = new HttpResult();
        result.setMsg(msg);
        return result;
    }

    /**
     * 请求OK
     *
     * @param data 数据
     * @return 请求结果
     */
    public static HttpResult ok(Object data) {
        HttpResult result = new HttpResult();
        result.setData(data);
        return result;
    }

    /**
     * 请求OK
     *
     * @return 请求结果
     */
    public static HttpResult ok() {
        return new HttpResult();
    }

    public int getCode() {
        return code;
    }

    public HttpResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public HttpResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public HttpResult setData(Object data) {
        this.data = data;
        return this;
    }
}
