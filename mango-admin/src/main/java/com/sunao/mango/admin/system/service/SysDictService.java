package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysDict;
import com.sunao.mango.core.service.CurdService;

import java.util.List;

/**
 * SysDictService 字典管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 14:45
 */
public interface SysDictService extends CurdService<SysDict> {
    /**
     * 根据标签名称查询
     *
     * @param name 标签名称
     * @return 结果列表
     */
    List<SysDict> findByName(String name);
}
