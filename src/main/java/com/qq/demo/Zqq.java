package com.qq.demo;




import com.qq.util.MyUtil;
import com.qq.util.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Zqq {
    public static void main(String[] args) throws ParseException, InterruptedException {
        System.out.println(MyUtil.getDateStart() + "," + MyUtil.getDateEnd());
        System.out.println(MyUtil.getDayBegin("2019-01-01") + "," + MyUtil.getDayEnd("2019-01-01"));
//        waitElement();
//        Person p1=new Person("111",98);
//        Person p2=new Person("111",80);
//        Person p3=new Person("111",70);
//        Person p4=new Person("111",66);
//        List<Person> list=new ArrayList<>();
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//        list.add(p4);
////        for (Person P:list
////             ) {
////            System.out.println(P.toString());
////
////        }
//        list.sort((a, b) -> a.getGrade() - b.getGrade());
//        for (Person P:list
//        ) {
//            System.out.println(P.toString());
//
//        }
//        list.stream().sorted((s1, s2) ->s1.getGrade() - s2.getGrade()).collect(Collectors.toList());
    }

//
//    static Function function = (str)->{
//        System.out.println(str);
//        WebDriver driver = null;
//        try {
//            driver = MyUtil.getDriver();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        WebDriverWait wait = new WebDriverWait(driver, 5); // 设置等待时间， 最大等待 5 秒
//        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(String.valueOf(str))));
//
//    };
//    public static  void waitElement( ) {
//        MyWait myWait = new MyWait("44");
//        Object until = myWait.until(function);
//        myWait.setStr("55");
//        until = myWait.until(function);
//    }





    }

