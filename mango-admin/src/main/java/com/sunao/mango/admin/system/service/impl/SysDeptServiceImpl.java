package com.sunao.mango.admin.system.service.impl;

import com.sunao.mango.admin.system.dao.SysDeptMapper;
import com.sunao.mango.admin.system.model.SysDept;
import com.sunao.mango.admin.system.service.SysDeptService;
import com.sunao.mango.core.page.MybatisPageHelper;
import com.sunao.mango.core.page.PageRequest;
import com.sunao.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * SysDeptServiceImpl 机构管理
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 15:51
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 保存操作
     *
     * @param record 保存的数据
     * @return 保存的数据条数
     */
    @Override
    public int save(SysDept record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDeptMapper.insertSelective(record);
        }
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除操作
     *
     * @param record 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除操作
     *
     * @param records 删除的数据
     * @return 删除的数据条数
     */
    @Override
    public int delete(List<SysDept> records) {
        for (SysDept record : records) {
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
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     *
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysDeptMapper);
    }

    /**
     * 查询机构树
     *
     * @return 机构树
     */
    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDeptList = new ArrayList<>();
        List<SysDept> deptList = sysDeptMapper.findAll();
        for (SysDept dept : deptList) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                sysDeptList.add(dept);
            }
        }
        findChildren(sysDeptList, deptList);
        return sysDeptList;
    }

    /**
     * 查询子机构
     *
     * @param sysDeptList 机构列表
     * @param deptList    所有机构列表
     */
    private void findChildren(List<SysDept> sysDeptList, List<SysDept> deptList) {
        for (SysDept sysDept : sysDeptList) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : deptList) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            //递归调用
            findChildren(children, deptList);
        }
    }
}
