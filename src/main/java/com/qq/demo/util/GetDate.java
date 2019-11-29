package com.qq.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    private static String dateStart;
    private static String dateEnd;
    static Date date = new Date();
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDateStart() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd ").format(dateFormat.parse("2019-01-01"));
    }

    public static void setDateStart(String dateStart) {
        GetDate.dateStart = dateStart;
    }

    public static String getDateEnd() {
        return new SimpleDateFormat("yyyy-MM-dd ").format(date);
    }

    public static void setDateEnd(String dateEnd) {
        GetDate.dateEnd = dateEnd;
    }
}
