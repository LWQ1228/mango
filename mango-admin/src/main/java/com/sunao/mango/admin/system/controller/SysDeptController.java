package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.model.SysDept;
import com.sunao.mango.admin.system.service.SysDeptService;
import com.sunao.mango.core.http.HttpResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysDeptController 机构控制器
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:43
 */
@RestController
@RequestMapping("system/dept")
public class SysDeptController {
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 保存数据
     *
     * @param record 数据信息
     * @return 保存结果
     */
    @PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    /**
     * 删除数据
     *
     * @param records 数据集合
     * @return 删除结果
     */
    @PreAuthorize("hasAuthority('sys:dept:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    /**
     * 查询机构树
     *
     * @return 机构树
     */
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value = "/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}
