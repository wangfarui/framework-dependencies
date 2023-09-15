package com.wfr.base.framework.common.utils;

/**
 * 字符工具类
 *
 * @author Wray
 * @since 2023/9/15
 */
public abstract class CharUtils {

    /**
     * 字符常量：点 {@code '.'}
     */
    static char DOT = '.';

    public static boolean isFileSeparator(char c) {
        return '/' == c || '\\' == c;
    }
}
