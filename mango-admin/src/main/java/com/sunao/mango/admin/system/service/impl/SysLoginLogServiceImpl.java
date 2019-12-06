package com.sunao.mango.admin.system.service.impl;

import com.sunao.mango.admin.system.dao.SysLoginLogMapper;
import com.sunao.mango.admin.system.model.SysLoginLog;
import com.sunao.mango.admin.system.service.SysLoginLogService;
import com.sunao.mango.core.page.MybatisPageHelper;
import com.sunao.mango.core.page.PageRequest;
import com.sunao.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysLoginLogServiceImpl 登录日志
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:00
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {
    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 保存操作
     *
     * @param record 保存的数据
     * @return 保存的数据条数
     */
    @Override
    public int save(SysLoginLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLoginLogMapper.insertSelective(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除操作
     *
     * @param record 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除操作
     *
     * @param records 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(List<SysLoginLog> records) {
        for (SysLoginLog record : records) {
            delete(record);
        }
        return 1;
    }

    /**
     * 根据ID查询
     *
     * @param id 编号
     * @return 查询到的数据
     */
    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     *
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        if (userName != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByUserName", userName);
        }
        Object status = pageRequest.getParam("status");
        if (status != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByStatus", status);
        }
        return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper);
    }
}
