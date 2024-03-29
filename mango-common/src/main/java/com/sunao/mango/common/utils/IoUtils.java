package com.sunao.mango.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IoUtils IO相关工具类
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/6 16:36
 */
public class IoUtils {
    /**
     * 关闭对象，连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
