package com.qq.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSet {
    public static String setFirstTime(String firstTime){

        //从日历中拿时间并转换格式
        Calendar c = Calendar.getInstance();
        // 时
        c.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        c.set(Calendar.MINUTE, 0);
        // 秒
        c.set(Calendar.SECOND, 0);
        // 毫秒
        c.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat sdf = new SimpleDateFormat(firstTime+"  HH:mm:ss SSS" );

        return sdf.format(c.getTime());
    }

    public static String setEndTime(String endTime){
        //从日历中拿时间并转换格式
        Calendar c = Calendar.getInstance();
        // 时
        c.set(Calendar.HOUR_OF_DAY, 23);
        // 分
        c.set(Calendar.MINUTE, 59);
        // 秒
        c.set(Calendar.SECOND, 59);
        // 毫秒
        c.set(Calendar.MILLISECOND, 999);

        SimpleDateFormat sdf = new SimpleDateFormat(endTime+"  HH:mm:ss SSS" );

        return sdf.format(c.getTime());
    }
}
