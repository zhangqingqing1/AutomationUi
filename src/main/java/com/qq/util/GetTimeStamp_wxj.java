package com.qq.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTimeStamp_wxj {
//    public static void main(String[] args){
//        Date date = new Date();
//        System.out.println(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        System.out.println(sdf.format(dayStart(date)));
//        System.out.println(sdf.format(dayEnd(date)));
//    }

    public static long dayEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTimeInMillis();
    }

    public static long dayStart(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
