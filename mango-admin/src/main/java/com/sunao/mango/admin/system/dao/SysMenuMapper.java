package com.sunao.mango.admin.system.dao;

import com.sunao.mango.admin.system.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysMenuMapper
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysMenuMapper {
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
    int insert(SysMenu record);

    /**
     * 保存部分数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insertSelective(SysMenu record);

    /**
     * 根据主键查询数据
     *
     * @param id 物理主键
     * @return 查询到的数据
     */
    SysMenu selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKeySelective(SysMenu record);

    /**
     * 根据主键更新部分数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKey(SysMenu record);

    /**
     * 分页查询
     *
     * @return 分页查询的数据
     */
    List<SysMenu> findPage();

    /**
     * 根据名称分页查询
     *
     * @param name 名称
     * @return 分页查询的数据
     */
    List<SysMenu> findPageByName(@Param(value = "name") String name);

    /**
     * 查询所有数据
     *
     * @return 查询的数据
     */
    List<SysMenu> findAll();

    /**
     * 根据用户名查询
     *
     * @param userName 用户名
     * @return 查询的数据
     */
    List<SysMenu> findByUserName(@Param(value = "userName") String userName);

    /**
     * 根据角色ID查询
     *
     * @param roleId 角色ID
     * @return 查询的数据
     */
    List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
}