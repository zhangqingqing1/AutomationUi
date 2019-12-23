package com.qq.pages;

import com.qq.Factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class BaiduPage {

    WebDriver driver;

    {
        try {
            driver = WebDriverFactory.getDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    WebDriverWait wait=new WebDriverWait(driver, 10);


    //百度搜索框输入关键字
    public  void setKeyword(String userText)
            throws NotFoundException {
        driver.findElement(By.id("kw")).sendKeys(userText);
    }

    //点击搜索
    public  void sousuoClick()
            throws NotFoundException {
        driver.findElement(By.id("su")).click();
    }

    //点击筛选
    public  void selectClick()
            throws NotFoundException {
        driver.findElement(By.className("search_tool")).click();
    }

    //点击确认按钮
    public void confirmClick()
            throws NotFoundException {
        driver.findElement(By.linkText("确认")).click();
    }

    //根据xpaht等待元素
    public  WebElement waitWebElementByxpath(String test) throws NotFoundException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(test)));
    }

    //根据id等待元素
    public  WebElement waitWebElementByid(String test) throws NotFoundException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(test)));
    }

    //得到结束时间日期元素
    public  WebElement getEnddate() throws NotFoundException {
        return driver.findElement(By.xpath("//*[@class=\"c-tip-custom-et\"]/input"));
    }

}
