package com.sunao.mango.backup.service.impl;

import com.sunao.mango.backup.beans.BackupRestoreParamBean;
import com.sunao.mango.backup.constants.BackupConstants;
import com.sunao.mango.backup.datasource.BackupDataSourceProperties;
import com.sunao.mango.backup.service.MysqlBackupService;
import com.sunao.mango.backup.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * MysqlBackupServiceImpl
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:43
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {
    @Resource
    BackupDataSourceProperties properties;

    /**
     * 备份数据库
     *
     * @param backupFolderName 数据库备份文件夹名
     * @return 备份结果
     * @throws Exception 异常信息
     */
    @Override
    public boolean backup(String backupFolderName) throws Exception {
        String backupFolderPath = BackupConstants.BACKUP_FOLDER + backupFolderName + File.separator;
        BackupRestoreParamBean paramBean = new BackupRestoreParamBean();
        paramBean.setHost(properties.getHost()).setUserName(properties.getUserName())
                .setPassword(properties.getPassword()).setDatabase(properties.getDatabase())
                .setBackupFolderPath(backupFolderPath).setFileName(BackupConstants.BACKUP_FILE_NAME);
        return MySqlBackupRestoreUtils.backup(paramBean);
    }

    /**
     * 恢复数据库
     *
     * @param sqlFileName 还原的SQL脚本文件名
     * @return 恢复结果
     * @throws Exception 异常信息
     */
    @Override
    public boolean restore(String sqlFileName) throws Exception {
        String restoreFilePath = BackupConstants.RESTORE_FOLDER + sqlFileName;
        BackupRestoreParamBean paramBean = new BackupRestoreParamBean();
        paramBean.setHost(properties.getHost()).setUserName(properties.getUserName())
                .setPassword(properties.getPassword()).setDatabase(properties.getDatabase())
                .setRestoreFilePath(restoreFilePath);
        return MySqlBackupRestoreUtils.restore(paramBean);
    }

    /**
     * 查询所有备份记录
     *
     * @return 备份记录
     */
    @Override
    public List<Map<String, String>> findBackupRecords() {
        List<Map<String, String>> backupRecords = new ArrayList<>();
        if (!new File(BackupConstants.DEFAULT_RESTORE_FILE).exists()) {
            // 初始默认备份文件
            try {
                backup(BackupConstants.DEFAULT_BACKUP_NAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File restoreFolderFile = new File(BackupConstants.RESTORE_FOLDER);
        if (restoreFolderFile.exists()) {
            for (File file : Objects.requireNonNull(restoreFolderFile.listFiles())) {
                Map<String, String> backup = new HashMap<>(2);
                backup.put("name", file.getName());
                backup.put("title", file.getName());
                if (BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
                    backup.put("title", "系统默认备份");
                }
                backupRecords.add(backup);
            }
        }
        // 排序，默认备份最前，然后按时间戳排序，新备份在前面
        backupRecords.sort((o1, o2) -> BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1
                : BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 : o2.get("name").compareTo(o1.get("name")));
        return backupRecords;
    }
}
