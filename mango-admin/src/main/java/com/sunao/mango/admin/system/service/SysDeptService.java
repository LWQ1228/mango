package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysDept;
import com.sunao.mango.core.service.CurdService;

import java.util.List;

/**
 * SysDeptService 机构管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 15:37
 */
public interface SysDeptService extends CurdService<SysDept> {
    /**
     * 查询机构树
     *
     * @return 机构树
     */
    List<SysDept> findTree();
}
