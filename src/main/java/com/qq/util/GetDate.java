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
}
