package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

/**
 * 配置表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysConfig extends BaseModel {
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

    public SysConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SysConfig setValue(String value) {
        this.value = value == null ? null : value.trim();
        return this;
    }

    public String getName() {
        return name;
    }

    public SysConfig setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getType() {
        return type;
    }

    public SysConfig setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SysConfig setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    public Long getSort() {
        return sort;
    }

    public SysConfig setSort(Long sort) {
        this.sort = sort;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public SysConfig setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
        return this;
    }
}