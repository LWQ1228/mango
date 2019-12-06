package com.sunao.mango.admin.system.dao;

import com.sunao.mango.admin.system.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysRoleMenuMapper
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysRoleMenuMapper {
    /**
     * 根据主键删除数据
     *
     * @param id 物理主键
     * @return 删除的数据条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insert(SysRoleMenu record);

    /**
     * 保存部分数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insertSelective(SysRoleMenu record);

    /**
     * 根据主键查询数据
     *
     * @param id 物理主键
     * @return 查询到的数据
     */
    SysRoleMenu selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKeySelective(SysRoleMenu record);

    /**
     * 根据主键更新部分数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKey(SysRoleMenu record);

    /**
     * 根据角色ID查询数据
     *
     * @param roleId 角色ID
     * @return 查询的数据
     */
    List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    List<SysRoleMenu> findAll();

    /**
     * 根据角色ID删除数据
     *
     * @param roleId 角色ID
     * @return 删除的数据条数
     */
    int deleteByRoleId(@Param(value = "roleId") Long roleId);
}