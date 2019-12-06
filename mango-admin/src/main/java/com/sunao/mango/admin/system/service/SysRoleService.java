package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysMenu;
import com.sunao.mango.admin.system.model.SysRole;
import com.sunao.mango.admin.system.model.SysRoleMenu;
import com.sunao.mango.core.service.CurdService;

import java.util.List;

/**
 * SysRoleService 角色管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 15:41
 */
public interface SysRoleService extends CurdService<SysRole> {
    /**
     * 查询全部角色
     *
     * @return 全部角色
     */
    List<SysRole> findAll();

    /**
     * 根据角色ID查询角色菜单集合
     *
     * @param roleId 角色ID
     * @return 角色菜单集合
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     *
     * @param records 角色菜单集合
     * @return 保存结果
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询角色列表
     *
     * @param name 名称
     * @return 角色列表
     */
    List<SysRole> findByName(String name);
}
