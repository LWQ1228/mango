package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 角色表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysRole extends BaseModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public SysRole setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysRole setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public SysRole setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
        return this;
    }
}