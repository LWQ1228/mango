package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysConfig;
import com.sunao.mango.core.service.CurdService;

import java.util.List;

/**
 * SysConfigService 系统配置管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 15:36
 */
public interface SysConfigService extends CurdService<SysConfig> {
    /**
     * 根据名称查询数据
     *
     * @param name 名称
     * @return 查询的数据
     */
    List<SysConfig> findByName(String name);
}
