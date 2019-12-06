package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

import java.util.List;

/**
 * 机构表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysDept extends BaseModel {
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

    /**
     * 非数据库字段 子节点列表
     */
    private List<SysDept> children;
    /**
     * 非数据库字段 父节点名称
     */
    private String parentName;
    /**
     * 非数据库字段 节点级别
     */
    private Integer level;

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

    public List<SysDept> getChildren() {
        return children;
    }

    public SysDept setChildren(List<SysDept> children) {
        this.children = children;
        return this;
    }

    public String getParentName() {
        return parentName;
    }

    public SysDept setParentName(String parentName) {
        this.parentName = parentName;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public SysDept setLevel(Integer level) {
        this.level = level;
        return this;
    }
}