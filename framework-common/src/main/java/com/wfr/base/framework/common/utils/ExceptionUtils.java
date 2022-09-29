package com.wfr.base.framework.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 *
 * @author wangfarui
 * @since 2022/9/29
 */
public abstract class ExceptionUtils {

    /**
     * 获取异常的调用栈信息
     *
     * @param exception 异常
     * @return 异常地调用栈信息
     */
    public static String exceptionStackTraceText(Throwable exception) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            exception.printStackTrace(pw);
        } catch (Exception e) {
            //ignore
        }
        pw.flush();

        return sw.toString();
    }

    /**
     * 不检查异常,返回运行异常
     *
     * @param e 异常
     */
    public static RuntimeException unchecked(Throwable e) {
        return (e instanceof RuntimeException) ? (RuntimeException) e : new RuntimeException(e);
    }
}
