package com.sunao.mango.backup.util;

import com.sunao.mango.backup.beans.BackupRestoreParamBean;

import java.io.*;

/**
 * MySqlBackupRestoreUtils MySQL备份还原工具类
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:32
 */
public class MySqlBackupRestoreUtils {
    /**
     * 备份数据库
     *
     * @param paramBean 数据库备份还原参数Bean
     * @return 备份结果
     * @throws Exception 异常信息
     */
    public static boolean backup(BackupRestoreParamBean paramBean) throws Exception {
        //获取备份参数
        String host = paramBean.getHost();
        String userName = paramBean.getUserName();
        String password = paramBean.getPassword();
        String backupFolderPath = paramBean.getBackupFolderPath();
        String fileName = paramBean.getFileName();
        String database = paramBean.getDatabase();

        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在则创建
            backupFolderFile.mkdirs();
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }
        // 拼接命令行的命令
        String backupFilePath = backupFolderPath + fileName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt ").append(" --add-drop-database ").append(" --add-drop-table ");
        stringBuilder.append(" -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database);
        // 调用外部执行 exe 文件的 Java API
        Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
        if (process.waitFor() == 0) {
            // 0 表示线程正常终止
            System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
            return true;
        } else {
            FileInputStream errorStream = (FileInputStream) process.getErrorStream();
            //读取
            InputStreamReader isr = new InputStreamReader(errorStream, "gbk");
            System.out.println(isr.getEncoding());
            //缓冲
            BufferedReader bufr = new BufferedReader(isr);
            String line = null;
            while ((line = bufr.readLine()) != null) {
                System.out.println(line);
            }
            isr.close();
        }
        return false;
    }

    /**
     * 还原数据库
     *
     * @param paramBean 数据库备份还原参数Bean
     * @return 还原结果
     * @throws Exception 异常信息
     */
    public static boolean restore(BackupRestoreParamBean paramBean) throws Exception {
        //获取还原参数
        String restoreFilePath = paramBean.getRestoreFilePath();
        String host = paramBean.getHost();
        String userName = paramBean.getUserName();
        String password = paramBean.getPassword();
        String database = paramBean.getDatabase();

        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
            } else {
                FileInputStream errorStream = (FileInputStream) process.getErrorStream();
                //读取
                InputStreamReader isr = new InputStreamReader(errorStream, "gbk");
                System.out.println(isr.getEncoding());
                //缓冲
                BufferedReader bufr = new BufferedReader(isr);
                String line = null;
                while ((line = bufr.readLine()) != null) {
                    System.out.println(line);
                }
                isr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取命令行
     *
     * @param command 命令
     * @return 命令行
     */
    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if (os.toLowerCase().startsWith("win")) {
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = {shell, c, command};
        return cmd;
    }
}
