package com.sunao.mango.admin.system.service.impl;

import com.sunao.mango.admin.system.dao.SysUserMapper;
import com.sunao.mango.admin.system.model.SysUser;
import com.sunao.mango.admin.system.service.SysUserService;
import com.sunao.mango.core.page.MybatisPageHelper;
import com.sunao.mango.core.page.PageRequest;
import com.sunao.mango.core.page.PageResult;
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

    /**
     * 保存操作
     *
     * @param record 保存的数据
     * @return 保存的数据条数
     */
    @Override
    public int save(SysUser record) {
        return 0;
    }

    /**
     * 删除操作
     *
     * @param record 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(SysUser record) {
        return 0;
    }

    /**
     * 批量删除操作
     *
     * @param records 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(List<SysUser> records) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id 编号
     * @return 查询到的数据
     */
    @Override
    public SysUser findById(Long id) {
        return null;
    }

    /**
     * 分页查询
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象，
     * 如MyBatis或JPA的分页对象从而避免因为替换ORM框架而导致服务层、
     * 控制层的分页接口也需要变动的情况，替换ORM框架也不会影响服务层
     * 以上的分页接口，起到了解耦的作用
     *
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysUserMapper);
    }
}
