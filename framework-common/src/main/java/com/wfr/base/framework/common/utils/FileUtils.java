package com.wfr.base.framework.common.utils;

/**
 * 文件工具类
 *
 * @author Wray
 * @since 2023/9/15
 */
public abstract class FileUtils {

    /**
     * 获取文件名
     * <p>
     * 例如：
     * <ul>
     *     <li>/Users/xxx/123.png -> 123.png</li>
     *     <li>123.png -> 123.png</li>
     *     <li>C:\Pictures\123.png -> 123.png</li>
     * </ul>
     *
     * @param filePath 文件路径
     * @return 带文件后缀的文件名
     */
    public static String getName(String filePath) {
        if (null == filePath) {
            return null;
        }
        int len = filePath.length();
        if (0 == len) {
            return filePath;
        }
        if (CharUtils.isFileSeparator(filePath.charAt(len - 1))) {
            // 以分隔符结尾的去掉结尾分隔符
            len--;
        }

        int begin = 0;
        char c;
        for (int i = len - 1; i > -1; i--) {
            c = filePath.charAt(i);
            if (CharUtils.isFileSeparator(c)) {
                // 查找最后一个路径分隔符（/或者\）
                begin = i + 1;
                break;
            }
        }

        return filePath.substring(begin, len);
    }

    /**
     * 获取主文件名
     * <p>
     * 例如：
     * <ul>
     *     <li>/Users/xxx/123.png -> 123</li>
     *     <li>123.png -> 123</li>
     *     <li>C:\Pictures\123.png -> 123</li>
     * </ul>
     *
     * @param filePath 文件路径
     * @return 不带文件后缀的文件名
     */
    public static String getMainName(String filePath) {
        if (null == filePath) {
            return null;
        }
        int len = filePath.length();
        if (0 == len) {
            return filePath;
        }
        if (CharUtils.isFileSeparator(filePath.charAt(len - 1))) {
            len--;
        }

        int begin = 0;
        int end = len;
        char c;
        for (int i = len - 1; i >= 0; i--) {
            c = filePath.charAt(i);
            if (len == end && CharUtils.DOT == c) {
                // 查找最后一个文件名和扩展名的分隔符：.
                end = i;
            }
            // 查找最后一个路径分隔符（/或者\），如果这个分隔符在.之后，则继续查找，否则结束
            if (CharUtils.isFileSeparator(c)) {
                begin = i + 1;
                break;
            }
        }

        return filePath.substring(begin, end);
    }
}
