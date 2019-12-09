package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.model.SysDict;
import com.sunao.mango.admin.system.service.SysDictService;
import com.sunao.mango.core.http.HttpResult;
import com.sunao.mango.core.page.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysDictController 字典控制器
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 14:54
 */
@RestController
@RequestMapping("system/dict")
public class SysDictController {
    @Resource
    private SysDictService sysDictService;

    /**
     * 保存数据
     *
     * @param record 需要保存的数据
     * @return 保存结果
     */
    @PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    /**
     * 删除数据
     *
     * @param records 删除保存的数据
     * @return 删除结果
     */
    @PreAuthorize("hasAuthority('sys:dict:delete') ")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDict> records) {
        return HttpResult.ok(sysDictService.delete(records));
    }

    /**
     * 查询数据
     *
     * @param pageRequest 查询条件
     * @return 查询结果
     */
    @PreAuthorize("hasAuthority('sys:dict:view') ")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    /**
     * 根据标签名称查询数据
     *
     * @param name 查询条件
     * @return 查询结果
     */
    @PreAuthorize("hasAuthority('sys:dict:view') ")
    @GetMapping(value = "/findByName")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysDictService.findByName(name));
    }
}
