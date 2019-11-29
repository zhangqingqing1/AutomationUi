package com.qq.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    private static String dateStart;
    private static String dateEnd;

    public static String getDateStart() throws ParseException {
        Calendar cr=Calendar.getInstance();
        cr.set(cr.getWeekYear(),00,01);
        return new SimpleDateFormat("yyyy-MM-dd ").format(cr.getTime());
    }

    public static void setDateStart(String dateStart) {
        GetDate.dateStart = dateStart;
    }

    public static String getDateEnd() {
        return new SimpleDateFormat("yyyy-MM-dd ").format(new Date());
    }

    public static void setDateEnd(String dateEnd) {
        GetDate.dateEnd = dateEnd;
    }
}
