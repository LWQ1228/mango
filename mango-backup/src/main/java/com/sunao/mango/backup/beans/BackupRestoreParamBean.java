package com.sunao.mango.backup.beans;

/**
 * BackupRestoreParamBean 数据库备份还原参数Bean
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:27
 */
public class BackupRestoreParamBean {
    /**
     * host地址，可以是本机也可以是远程
     */
    private String host;
    /**
     * 数据库的名称
     */
    private String database;
    /**
     * 数据库的用户名
     */
    private String userName;
    /**
     * 数据库的密码
     */
    private String password;
    /**
     * 备份的文件夹路径
     */
    private String backupFolderPath;
    /**
     * 备份的文件名
     */
    private String fileName;
    /**
     * 数据库恢复备份的脚本路径
     */
    private String restoreFilePath;

    public String getHost() {
        return host;
    }

    public BackupRestoreParamBean setHost(String host) {
        this.host = host;
        return this;
    }

    public String getDatabase() {
        return database;
    }

    public BackupRestoreParamBean setDatabase(String database) {
        this.database = database;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public BackupRestoreParamBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public BackupRestoreParamBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getBackupFolderPath() {
        return backupFolderPath;
    }

    public BackupRestoreParamBean setBackupFolderPath(String backupFolderPath) {
        this.backupFolderPath = backupFolderPath;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public BackupRestoreParamBean setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getRestoreFilePath() {
        return restoreFilePath;
    }

    public BackupRestoreParamBean setRestoreFilePath(String restoreFilePath) {
        this.restoreFilePath = restoreFilePath;
        return this;
    }
}
