package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.service.SysUserService;
import com.sunao.mango.core.http.HttpResult;
import com.sunao.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 分页查询用户数据
     *
     * @return 分页的用户数据
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }
}
