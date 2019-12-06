package com.sunao.mango.admin.base.model;

import java.util.Date;

/**
 * BaseModel
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/04
 */
public class BaseModel {
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;

    /**
     * 是否删除（-1：已删除 、0：正常）
     */
    private Integer delFlag;

    public String getCreateBy() {
        return createBy;
    }

    public BaseModel setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public BaseModel setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public BaseModel setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public BaseModel setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public BaseModel setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}
