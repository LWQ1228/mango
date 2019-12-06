package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 机构表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysDept extends BaseModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级机构ID，一级机构为0
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer orderNum;

    public Long getId() {
        return id;
    }

    public SysDept setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysDept setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public SysDept setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public SysDept setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }
}