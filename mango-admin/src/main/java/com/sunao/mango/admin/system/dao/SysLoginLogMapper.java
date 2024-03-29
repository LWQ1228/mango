package com.sunao.mango.admin.system.dao;

import com.sunao.mango.admin.system.model.SysLog;
import com.sunao.mango.admin.system.model.SysLoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysLoginLogMapper
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysLoginLogMapper {
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
    int insert(SysLoginLog record);

    /**
     * 保存部分数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insertSelective(SysLoginLog record);

    /**
     * 根据主键查询数据
     *
     * @param id 物理主键
     * @return 查询到的数据
     */
    SysLoginLog selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKeySelective(SysLoginLog record);

    /**
     * 根据主键更新部分数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKey(SysLoginLog record);

    /**
     * 分页查询
     *
     * @return 分页查询的数据
     */
    List<SysLog> findPage();

    /**
     * 根据用户名分页查询
     *
     * @param userName 用户名
     * @return 分页查询的数据
     */
    List<SysLog> findPageByUserName(@Param(value = "userName") String userName);

    /**
     * 根据状态分页查询
     *
     * @param status 状态
     * @return 分页查询的数据
     */
    List<SysLog> findPageByStatus(@Param(value = "status") String status);
}