package com.qq.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 获取当年的第一天的日期
     *
     * @return “yyyy-MM-dd”
     */
    public static String firstDayOfYear() {
        return new SimpleDateFormat("yyyy-01-01").format(new Date());
    }

    /**
     * 获取当天日期
     *
     * @return “yyyy-MM-dd”
     */
    public static String currentDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取当天的00:00:00.000
     *
     * @param date
     * @return
     */
    public static long dayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setDayStart(calendar);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当天的23:59:59.999
     *
     * @param date
     * @return
     */
    public static long dayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setDayEnd(calendar);
        return calendar.getTimeInMillis();
    }

    public static void setDayStart(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static void setDayEnd(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }
}
