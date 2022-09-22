package com.wfr.base.framework.common.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 *
 * @author wangfarui
 * @since 2022/9/22
 */
public abstract class CollectionUtils {

    /**
     * Collection集合类是否为空 (null or empty)
     *
     * @param collection Collection集合
     * @return true -> 空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Map映射集合类是否为空 (null or empty)
     *
     * @param map Map集合
     * @return true -> 空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Collection集合类是否不为空 (!null and !empty)
     *
     * @param collection Collection集合
     * @return true -> 非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * Map映射集合类是否不为空 (!null and !empty)
     *
     * @param map Map集合
     * @return true -> 非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

}
