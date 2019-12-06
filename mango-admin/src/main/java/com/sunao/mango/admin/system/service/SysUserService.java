package com.sunao.mango.admin.system.service;

import com.sunao.mango.admin.system.model.SysUser;

import java.util.List;

/**
 * SysUserService
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public interface SysUserService {
    /**
     * 查询所有用户数据
     *
     * @return 所有用户数据
     */
    List<SysUser> findAll();
}
