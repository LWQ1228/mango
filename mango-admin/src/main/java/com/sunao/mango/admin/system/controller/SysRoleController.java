package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.constant.SysConstants;
import com.sunao.mango.admin.system.model.SysRole;
import com.sunao.mango.admin.system.model.SysRoleMenu;
import com.sunao.mango.admin.system.service.SysRoleService;
import com.sunao.mango.core.http.HttpResult;
import com.sunao.mango.core.page.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysRoleController 角色控制器
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:51
 */
@RestController
@RequestMapping("system/role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 保存数据
     *
     * @param record 数据信息
     * @return 保存结果
     */
    @PreAuthorize("hasAuthority('sys:role:add') AND hasAuthority('sys:role:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysRole record) {
        SysRole role = sysRoleService.findById(record.getId());
        if (role != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        // 新增角色
        if (record.getId() == null || record.getId() == 0) {
            if (!sysRoleService.findByName(record.getName()).isEmpty()) {
                return HttpResult.error("角色名已存在!");
            }
        }
        return HttpResult.ok(sysRoleService.save(record));
    }

    /**
     * 删除数据
     *
     * @param records 数据集合
     * @return 删除结果
     */
    @PreAuthorize("hasAuthority('sys:role:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        return HttpResult.ok(sysRoleService.delete(records));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 查询条件
     * @return 查询结果
     */
    @PreAuthorize("hasAuthority('sys:role:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @PreAuthorize("hasAuthority('sys:role:view')")
    @GetMapping(value = "/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    /**
     * 根据角色ID查询菜单列表
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    @PreAuthorize("hasAuthority('sys:role:view')")
    @GetMapping(value = "/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    /**
     * 保存角色菜单
     *
     * @param records 菜单列表
     * @return 保存结果
     */
    @PreAuthorize("hasAuthority('sys:role:view')")
    @PostMapping(value = "/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
        for (SysRoleMenu record : records) {
            SysRole sysRole = sysRoleService.findById(record.getRoleId());
            if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
