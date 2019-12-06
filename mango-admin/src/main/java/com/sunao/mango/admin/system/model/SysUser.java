package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysUser extends BaseModel {
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
    private Long deptId;

    /**
     * 非数据库字段 部门名称
     */
    private String deptName;

    /**
     * 非数据库字段 角色名称
     */
    private String roleNames;

    /**
     * 非数据库字段 用户角色列表
     */
    private List<SysUserRole> userRoles = new ArrayList<>();

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

    public Long getDeptId() {
        return deptId;
    }

    public SysUser setDeptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public SysUser setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public SysUser setRoleNames(String roleNames) {
        this.roleNames = roleNames;
        return this;
    }

    public List<SysUserRole> getUserRoles() {
        return userRoles;
    }

    public SysUser setUserRoles(List<SysUserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}