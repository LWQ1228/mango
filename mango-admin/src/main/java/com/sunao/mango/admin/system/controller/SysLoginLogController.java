package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.model.SysLoginLog;
import com.sunao.mango.admin.system.service.SysLoginLogService;
import com.sunao.mango.core.http.HttpResult;
import com.sunao.mango.core.page.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysLoginLogController 登录日志控制器
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:47
 */
@RestController
@RequestMapping("system/loginLog")
public class SysLoginLogController {
    @Resource
    private SysLoginLogService sysLoginLogService;

    /**
     * 分页查询
     *
     * @param pageRequest 查询参数
     * @return 查询结果
     */
    @PreAuthorize("hasAuthority('sys:loginlog:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    /**
     * 删除数据
     *
     * @param records 数据集合
     * @return 删除结果
     */
    @PreAuthorize("hasAuthority('sys:loginlog:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
