package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    private static String dateStart;
    private static String dateEnd;
    static Date date = new Date();
    static String date1 = new SimpleDateFormat("yyyy-MM-dd ").format(date);

    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static Date myDate1;

    static {
        try {
            myDate1 = dateFormat.parse("2019-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static String dateStr1 = new SimpleDateFormat("yyyy-MM-dd ").format(myDate1);


    public GetDate() throws ParseException {
    }

    public static String getDateStart() {
        return dateStr1 ;
    }

    public static void setDateStart(String dateStart) {
        GetDate.dateStart = dateStart;
    }

    public static String getDateEnd() {
        return date1;
    }

    public static void setDateEnd(String dateEnd) {
        GetDate.dateEnd = dateEnd;
    }
}
