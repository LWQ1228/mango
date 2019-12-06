package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysMenu;
import com.sunao.mango.core.service.CurdService;

import java.util.List;

/**
 * SysMenuService 菜单管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 15:39
 */
public interface SysMenuService extends CurdService<SysMenu> {
    /**
     * 根据用户名和菜单类型查询菜单树
     *
     * @param userName 用户名
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @return 菜单树
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     *
     * @param userName 用户名
     * @return 菜单列表
     */
    List<SysMenu> findByUser(String userName);
}
