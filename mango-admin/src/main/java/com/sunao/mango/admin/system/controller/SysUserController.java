package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author liuwenqing
 * @blame 刘文清
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有用户数据
     *
     * @return 所有用户数据
     */
    @GetMapping(value = "/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

}
