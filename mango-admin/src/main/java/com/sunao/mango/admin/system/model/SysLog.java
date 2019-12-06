package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 操作日志表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysLog extends BaseModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 执行时长（毫秒）
     */
    private Long time;

    /**
     * IP地址
     */
    private String ip;

    public Long getId() {
        return id;
    }

    public SysLog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public SysLog setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public SysLog setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
        return this;
    }

    public String getMethod() {
        return method;
    }

    public SysLog setMethod(String method) {
        this.method = method == null ? null : method.trim();
        return this;
    }

    public String getParams() {
        return params;
    }

    public SysLog setParams(String params) {
        this.params = params == null ? null : params.trim();
        return this;
    }

    public Long getTime() {
        return time;
    }

    public SysLog setTime(Long time) {
        this.time = time;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public SysLog setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
        return this;
    }
}