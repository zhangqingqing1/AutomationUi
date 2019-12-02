package com.qq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    //注释无用的代码
    /*
    private static String dateStart;
    private static String dateEnd;*/

    public static String getDateStart() throws ParseException {
        return Calendar.getInstance().get(Calendar.YEAR) + "-01-01";
    }

    public static String getDateEnd() {
        return new SimpleDateFormat("yyyy-MM-dd ").format(new Date());
    }

    public static Long getMonthBegin(String datestr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(datestr);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis();
    }


    public static Long getMonthEnd(String datestrr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(datestrr);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTimeInMillis();
    }
}