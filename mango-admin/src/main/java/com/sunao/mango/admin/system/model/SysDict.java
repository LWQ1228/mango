package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 字典表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysDict extends BaseModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private Long sort;

    /**
     * 备注信息
     */
    private String remarks;

    public Long getId() {
        return id;
    }

    public SysDict setId(Long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SysDict setValue(String value) {
        this.value = value == null ? null : value.trim();
        return this;
    }

    public String getName() {
        return name;
    }

    public SysDict setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getType() {
        return type;
    }

    public SysDict setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SysDict setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    public Long getSort() {
        return sort;
    }

    public SysDict setSort(Long sort) {
        this.sort = sort;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public SysDict setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
        return this;
    }
}