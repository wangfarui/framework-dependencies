package com.wfr.base.framework.common.utils;

/**
 * {@link String} 工具类
 *
 * @author wangfarui
 * @since 2022/8/30
 */
public abstract class StringUtils {

    /**
     * 字符串是否为空
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = false
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs 字符串
     * @return ture -> 空
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 字符串是否非空
     * <pre>
     * StringUtils.isBlank(null)      = false
     * StringUtils.isBlank("")        = false
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = ture
     * StringUtils.isBlank("  bob  ") = ture
     * </pre>
     *
     * @param cs 字符串
     * @return true -> 非空
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 字符串是否为空或空白
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs 字符串
     * @return true -> 空
     */
    public static boolean isBlank(CharSequence cs) {
        if (cs == null) {
            return true;
        }
        int len = cs.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串是否为非空或非空白
     * <pre>
     * StringUtils.isBlank(null)      = false
     * StringUtils.isBlank("")        = false
     * StringUtils.isBlank(" ")       = false
     * StringUtils.isBlank("bob")     = true
     * StringUtils.isBlank("  bob  ") = true
     * </pre>
     *
     * @param cs 字符串
     * @return true -> 非空
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
}
