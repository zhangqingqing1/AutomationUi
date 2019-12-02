package com.qq.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.function.Function;

public  class MyWait implements Wait {

    private String str;

    public MyWait(String str) {
        this.str = str;
    }

    @Override
    public  Object until(Function function) {
        return  function.apply(str);
    }

    public void setStr(String str) {
        this.str = str;
    }
}
