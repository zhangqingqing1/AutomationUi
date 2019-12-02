package com.qq.demo;




import com.qq.util.GetDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class zqq {
    public static void main(String[] args) throws ParseException {
//        Date date = new Date();
//        String dateStr = new SimpleDateFormat("yyyy-MM-dd ").format(date);
//        System.out.println(dateStr);
//        Calendar cr=Calendar.getInstance();
//        int year=cr.getWeekYear();
//        cr.set(year,00,01);
//        Date date1=cr.getTime();
//        String dateStr1 = new SimpleDateFormat("yyyy-MM-dd ").format(date1);
//        System.out.println(dateStr1);
        System.out.println(GetDate.getDateStart() + "," + GetDate.getDateEnd());

        System.out.println(GetDate.getMonthBegin("2019-01-01") + "," + GetDate.getMonthEnd("2019-01-01"));


    }


    }

