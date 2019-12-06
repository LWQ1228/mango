package com.sunao.mango.admin.system.dao;

import com.sunao.mango.admin.system.model.SysUser;

import java.util.List;

/**
 * SysUserMapper
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysUserMapper {
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
    int insert(SysUser record);

    /**
     * 保存部分数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键查询数据
     *
     * @param id 物理主键
     * @return 查询到的数据
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据主键更新部分数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 查询所有用户数据
     *
     * @return 所有用户数据
     */
    List<SysUser> findAll();
}