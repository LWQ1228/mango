package com.sunao.mango.admin.system.model;

import com.sunao.mango.admin.base.model.BaseModel;

import java.util.List;

/**
 * 菜单表
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class SysMenu extends BaseModel {
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单URL，类型：1、普通页面（如用户管理，/sys/user）；2、嵌套完整外部页面，以http(s)开头的链接；3、嵌套服务器页面，使用iframe:前缀+目标URL（如SQL监控，iframe:/druid/login.html，iframe:前缀会替换成服务器地址）
     */
    private String url;

    /**
     * 授权（多个用逗号隔开，如：sys:user:add，sys:user:edit）
     */
    private String perms;

    /**
     * 类型（0：目录 、1：菜单、2：按钮）
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 非数据库字段 父节点名称
     */
    private String parentName;

    /**
     * 非数据库字段 树级别
     */
    private Integer level;

    /**
     * 非数据库字段 子节点列表
     */
    private List<SysMenu> children;

    public String getName() {
        return name;
    }

    public SysMenu setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public SysMenu setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SysMenu setUrl(String url) {
        this.url = url == null ? null : url.trim();
        return this;
    }

    public String getPerms() {
        return perms;
    }

    public SysMenu setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SysMenu setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public SysMenu setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public SysMenu setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public String getParentName() {
        return parentName;
    }

    public SysMenu setParentName(String parentName) {
        this.parentName = parentName;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public SysMenu setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public SysMenu setChildren(List<SysMenu> children) {
        this.children = children;
        return this;
    }
}