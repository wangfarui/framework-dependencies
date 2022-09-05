package com.wfr.base.framework.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author wangfarui
 * @since 2022/7/1
 */
public abstract class DateTimeUtils {

    private static final Logger log = LoggerFactory.getLogger(DateTimeUtils.class);

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 转换日期字符串为日期
     *
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static Date convertStringDateToDate(String dateStr) {
        return convertStringDateToDate(dateStr, DATETIME_PATTERN);
    }

    /**
     * 转换日期字符串为指定日期格式的日期
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式
     * @return 日期
     */
    public static Date convertStringDateToDate(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if (StringUtils.isEmpty(pattern)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            try {
                return sdf.parse(dateStr.trim());
            } catch (ParseException ex) {
                log.error("Convert String Date To Long Date Exception.", ex);
            }
        }

        return null;
    }

    /**
     * 获取 指定日期时间 0点0分0秒0毫秒的时间戳
     *
     * @param date 指定日期时间
     * @return 时间戳
     */
    public static long getZeroMillisecondByDate(Date date) {
        return getZeroMillisecondByDate(date, 0);
    }

    /**
     * 获取 指定日期时间、指定n天后 0点0分0秒0毫秒的时间戳
     *
     * @param date 指定日期时间
     * @param n    天数（为负数时, 代表前n天）
     * @return 时间戳
     */
    public static long getZeroMillisecondByDate(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (n != 0) {
            int day = n > 0 ? n - 1 : n + 1;
            calendar.add(Calendar.DATE, day);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
