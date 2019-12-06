package com.sunao.mango.admin.system.service.impl;

import com.sunao.mango.admin.system.dao.SysConfigMapper;
import com.sunao.mango.admin.system.model.SysConfig;
import com.sunao.mango.admin.system.service.SysConfigService;
import com.sunao.mango.core.page.MybatisPageHelper;
import com.sunao.mango.core.page.PageRequest;
import com.sunao.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysConfigServiceImpl 系统配置管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 15:45
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Resource
    private SysConfigMapper sysConfigMapper;

    /**
     * 保存数据
     *
     * @param record 保存的数据
     * @return 保存结果
     */
    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除数据
     *
     * @param record 删除的数据
     * @return 删除结果
     */
    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除数据
     *
     * @param records 删除的数据
     * @return 删除结果
     */
    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record : records) {
            delete(record);
        }
        return 1;
    }

    /**
     * 根据ID查询数据
     *
     * @param id 编号
     * @return 查询的数据
     */
    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询分页数据
     *
     * @param pageRequest 自定义，统一分页查询请求
     * @return 查询的数据
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object name = pageRequest.getParam("name");
        if (name != null) {
            return MybatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByName", name);
        }
        return MybatisPageHelper.findPage(pageRequest, sysConfigMapper);
    }

    /**
     * 根据名称查询数据
     *
     * @param name 名称
     * @return 查询的数据
     */
    @Override
    public List<SysConfig> findByName(String name) {
        return sysConfigMapper.findByName(name);
    }
}
