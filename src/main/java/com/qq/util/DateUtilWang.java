package com.qq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilWang {
    public static String getFirstDayOfCurrentYear(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-01-01");
        return df.format(new Date());
    }
    public static String getCurrentDay(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
}
