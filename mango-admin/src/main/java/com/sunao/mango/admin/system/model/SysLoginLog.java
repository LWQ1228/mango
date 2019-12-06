package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 登录日志表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysLoginLog extends BaseModel {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录状态（online：在线，登录初始状态，方便统计在线人数；login：退出登录后将online置为login；logout：退出登录）
     */
    private String status;

    /**
     * IP地址
     */
    private String ip;

    public String getUserName() {
        return userName;
    }

    public SysLoginLog setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SysLoginLog setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    public String getIp() {
        return ip;
    }

    public SysLoginLog setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
        return this;
    }
}