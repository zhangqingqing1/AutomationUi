package com.qq.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class getDate {
    private  String date0101;
    private  String datenow;
    DateFormat format= new SimpleDateFormat("yy-mm-dd");
    Date date = new Date();


    public void setDate0101(String date0101) {
        this.date0101 = format.format(date);
    }

    public void setDatenow(String datenow) {
        this.datenow = format.format(new Date());
    }

    public String getDate0101() {
        return date0101;
    }

    public String getDatenow() {
        return datenow;
    }
}
