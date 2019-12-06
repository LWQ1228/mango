package com.sunao.mango.admin.system.dao;

import com.sunao.mango.admin.system.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysUserRoleMapper
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysUserRoleMapper {
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
    int insert(SysUserRole record);

    /**
     * 保存部分数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insertSelective(SysUserRole record);

    /**
     * 根据主键查询数据
     *
     * @param id 物理主键
     * @return 查询到的数据
     */
    SysUserRole selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * 根据主键更新部分数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKey(SysUserRole record);

    /**
     * 根据用户ID查询数据
     *
     * @param userId 用户ID
     * @return 查询的数据
     */
    List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);

    /**
     * 根据用户ID删除数据
     *
     * @param userId 用户ID
     * @return 删除的数据条数
     */
    int deleteByUserId(@Param(value = "userId") Long userId);
}