package com.qq.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getTimeStamp_wxj {
//    public static void main(String[] args){
//        Date date = new Date();
//        System.out.println(getStartOfDay(date));
//        System.out.println(getEndOfDay(date));
//    }

    public static String getEndOfDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return sdf.format(cal.getTime());
    }

    public static String getStartOfDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return sdf.format(cal.getTime());
    }
}
