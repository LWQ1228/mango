package com.sunao.mango.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTimeUtils 日期时间相关工具
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:33
 */
public class DateTimeUtils {
    /**
     * 默认日期格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     *
     * @return 当前标准格式化日期时间
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     *
     * @param date 日期
     * @return 格式化后的日期
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }
}
