package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysUser;
import com.sunao.mango.admin.system.model.SysUserRole;
import com.sunao.mango.core.page.PageRequest;
import com.sunao.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * SysUserService 用户管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysUserService extends CurdService<SysUser> {

    /**
     * 根据用户名查询用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    SysUser findByName(String name);

    /**
     * 根据用户名查找用户的菜单权限标识集合
     *
     * @param userName 用户名
     * @return 用户的菜单权限标识集合
     */
    Set<String> findPermissions(String userName);

    /**
     * 根据用户ID查找用户的角色集合
     *
     * @param userId 用户ID
     * @return 用户的角色集合
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     *
     * @param pageRequest 要导出的分页查询参数
     * @return 用户信息Excel文件
     */
    File createUserExcelFile(PageRequest pageRequest);
}
