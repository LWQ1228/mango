package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 用户表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysUser extends BaseModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态（0：禁用 、1：正常）
     */
    private Integer status;

    /**
     * 机构ID
     */
    private Long detpId;

    public Long getId() {
        return id;
    }

    public SysUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysUser setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public SysUser setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public SysUser setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public SysUser setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SysUser setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public SysUser setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SysUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getDetpId() {
        return detpId;
    }

    public SysUser setDetpId(Long detpId) {
        this.detpId = detpId;
        return this;
    }
}