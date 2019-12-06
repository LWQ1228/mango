package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 角色机构表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysRoleDept extends BaseModel {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 机构ID
     */
    private Long deptId;

    public Long getRoleId() {
        return roleId;
    }

    public SysRoleDept setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getDeptId() {
        return deptId;
    }

    public SysRoleDept setDeptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }
}