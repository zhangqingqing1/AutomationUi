package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    private static String date0101;
    private static String datenow;
    DateFormat format= new SimpleDateFormat("yy-mm-dd");
    Date date = new Date();
    Calendar cr=Calendar.getInstance();

    public void setDate0101(String date0101) {
        this.date0101 = format.format(date);
    }

    public void setDatenow(String datenow) {
        this.datenow = format.format(new Date());
    }

    public  static String getDate0101() {
        return date0101;
    }

    public static String getDatenow() {
        return datenow;
    }
}
