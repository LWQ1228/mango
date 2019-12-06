package com.sunao.mango.admin.system.service.impl;

import com.sunao.mango.admin.system.dao.SysUserMapper;
import com.sunao.mango.admin.system.model.SysUser;
import com.sunao.mango.admin.system.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysUserServiceImpl
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 查询所有用户数据
     *
     * @return 所有用户数据
     */
    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
}
