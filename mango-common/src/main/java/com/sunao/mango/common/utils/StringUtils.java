package com.sunao.mango.common.utils;

/**
 * StringUtils 字符串工具类
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 17:11
 */
public class StringUtils {
    /**
     * 判空操作
     *
     * @param value 值
     * @return 判断结果
     */
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

    /**
     * 判断不为空操作
     *
     * @param value 值
     * @return 判断结果
     */
    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }
}
