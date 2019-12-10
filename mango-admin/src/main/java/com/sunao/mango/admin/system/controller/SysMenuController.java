package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.model.SysMenu;
import com.sunao.mango.admin.system.service.SysMenuService;
import com.sunao.mango.core.http.HttpResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysMenuController 菜单控制器
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:49
 */
@RestController
@RequestMapping("system/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 保存数据
     *
     * @param record 数据信息
     * @return 保存结果
     */
    @PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    /**
     * 删除数据
     *
     * @param records 数据集合
     * @return 删除结果
     */
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        return HttpResult.ok(sysMenuService.delete(records));
    }

    /**
     * 根据用户名查询菜单树
     *
     * @param userName 用户名
     * @return 菜单树
     */
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    /**
     * 查询菜单树
     *
     * @return 菜单树
     */
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }
}
