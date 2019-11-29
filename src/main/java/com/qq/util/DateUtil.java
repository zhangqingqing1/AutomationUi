package com.qq.util;

import java.text.SimpleDateFormat;
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
}
