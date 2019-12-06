package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 用户角色表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysUserRole extends BaseModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    public Long getId() {
        return id;
    }

    public SysUserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public SysUserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public SysUserRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }
}