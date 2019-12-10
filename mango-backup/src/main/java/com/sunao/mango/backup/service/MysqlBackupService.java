package com.sunao.mango.backup.service;

import java.util.List;
import java.util.Map;

/**
 * MysqlBackupService MySql命令行备份恢复服务
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:23
 */
public interface MysqlBackupService {
    /**
     * 备份数据库
     *
     * @param backupFolderName 数据库备份文件夹名
     * @return 备份结果
     * @throws Exception 异常信息
     */
    boolean backup(String backupFolderName) throws Exception;

    /**
     * 恢复数据库
     *
     * @param sqlFileName 还原的SQL脚本文件名
     * @return 恢复结果
     * @throws Exception 异常信息
     */
    boolean restore(String sqlFileName) throws Exception;

    /**
     * 查询所有备份记录
     *
     * @return 备份记录
     */
    List<Map<String, String>> findBackupRecords();
}
