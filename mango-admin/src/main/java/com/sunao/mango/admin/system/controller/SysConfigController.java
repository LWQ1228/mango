package com.sunao.mango.admin.system.controller;

import com.sunao.mango.admin.system.model.SysConfig;
import com.sunao.mango.admin.system.service.SysConfigService;
import com.sunao.mango.core.http.HttpResult;
import com.sunao.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysConfigController 系统配置控制器
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:38
 */
@RestController
@RequestMapping("system/config")
public class SysConfigController {
    @Resource
    private SysConfigService sysConfigService;

    /**
     * 保存数据
     *
     * @param record 数据信息
     * @return 保存结果
     */
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    /**
     * 删除数据
     *
     * @param records 数据集合
     * @return 删除结果
     */
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    /**
     * 分页查询数据
     *
     * @param pageRequest 查询参数
     * @return 查询结果
     */
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    /**
     * 根据名称查询数据
     *
     * @param name 名称
     * @return 查询结果
     */
    @GetMapping(value = "/findByName")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysConfigService.findByName(name));
    }
}
