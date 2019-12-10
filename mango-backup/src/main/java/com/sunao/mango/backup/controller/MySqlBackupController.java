package com.sunao.mango.backup.controller;

import com.sunao.mango.backup.constants.BackupConstants;
import com.sunao.mango.backup.service.MysqlBackupService;
import com.sunao.mango.backup.util.HttpResult;
import com.sunao.mango.common.utils.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MySqlBackupController 系统数据备份还原
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:56
 */
@RestController
@RequestMapping("/backup")
public class MySqlBackupController {
    @Resource
    MysqlBackupService mysqlBackupService;

    /**
     * 数据库备份处理
     *
     * @return 备份结果
     */
    @GetMapping("/backup")
    public HttpResult backup() {
        String backupFolderName = BackupConstants.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(BackupConstants.DATE_FORMAT)).format(new Date());
        return backup(backupFolderName);
    }

    /**
     * 数据库备份处理-指定备份路径
     *
     * @param backupFolderName 备份路径
     * @return 备份结果
     */
    private HttpResult backup(String backupFolderName) {
        try {
            boolean success = mysqlBackupService.backup(backupFolderName);
            if (!success) {
                HttpResult.error("数据备份失败");
            }
        } catch (Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

    /**
     * 数据库还原接口
     *
     * @param sqlFileName 还原脚本文件名
     * @return 还原结果
     */
    @GetMapping("/restore")
    public HttpResult restore(@RequestParam String sqlFileName) {
        try {
            boolean success = mysqlBackupService.restore(sqlFileName);
            if (!success) {
                HttpResult.error("数据还原失败");
            }
        } catch (Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

    /**
     * 查询所有备份记录
     *
     * @return 备份记录
     */
    @GetMapping("/findRecords")
    public HttpResult findBackupRecords() {
        return HttpResult.ok(mysqlBackupService.findBackupRecords());
    }

    /**
     * 删除备份文件
     *
     * @param sqlFileName SQL脚本文件名
     * @return 删除结果
     */
    @GetMapping("/delete")
    public HttpResult deleteBackupRecord(@RequestParam String sqlFileName) {
        if (BackupConstants.DEFAULT_BACKUP_NAME.equals(sqlFileName)) {
            return HttpResult.error("系统默认备份无法删除!");
        }
        String restoreFilePath = BackupConstants.BACKUP_FOLDER + sqlFileName;
        try {
            FileUtils.deleteFile(new File(restoreFilePath));
        } catch (Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }
}
