package com.sunao.mango.admin.system.service.impl;

import com.sunao.mango.admin.system.dao.SysDictMapper;
import com.sunao.mango.admin.system.model.SysDict;
import com.sunao.mango.admin.system.service.SysDictService;
import com.sunao.mango.core.page.MybatisPageHelper;
import com.sunao.mango.core.page.PageRequest;
import com.sunao.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysDictServiceImpl
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 14:46
 */
@Service
public class SysDictServiceImpl implements SysDictService {
    @Resource
    private SysDictMapper sysDictMapper;

    /**
     * 根据标签名称查询
     *
     * @param name 标签名称
     * @return 结果列表
     */
    @Override
    public List<SysDict> findByName(String name) {
        return sysDictMapper.findByName(name);
    }

    /**
     * 保存操作
     *
     * @param record 保存的数据
     * @return 保存的数据条数
     */
    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除操作
     *
     * @param record 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除操作
     *
     * @param records 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
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
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     *
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        //取得name参数
        Object name = pageRequest.getParam("name");
        //如果参数不为空
        if (name != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByName", name);
        }
        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }
}
