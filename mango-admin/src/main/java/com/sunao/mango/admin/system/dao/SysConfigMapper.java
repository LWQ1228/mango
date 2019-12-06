package com.sunao.mango.admin.system.dao;

import com.sunao.mango.admin.system.model.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysConfigMapper
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysConfigMapper {
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
    int insert(SysConfig record);

    /**
     * 保存部分数据
     *
     * @param record 保存的数据信息
     * @return 保存的数据条数
     */
    int insertSelective(SysConfig record);

    /**
     * 根据主键查询数据
     *
     * @param id 物理主键
     * @return 查询到的数据
     */
    SysConfig selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKeySelective(SysConfig record);

    /**
     * 根据主键更新部分数据
     *
     * @param record 需要更新的数据
     * @return 更新的数据条数
     */
    int updateByPrimaryKey(SysConfig record);

    /**
     * 分页查询
     *
     * @return 分页查询的数据
     */
    List<SysConfig> findPage();

    /**
     * 根据名称查询
     *
     * @param name 名称
     * @return 查询的数据
     */
    List<SysConfig> findByName(@Param(value = "name") String name);

    /**
     * 根据名称分页查询
     *
     * @param name 名称
     * @return 分页查询的数据
     */
    List<SysConfig> findPageByName(@Param(value = "name") String name);
}