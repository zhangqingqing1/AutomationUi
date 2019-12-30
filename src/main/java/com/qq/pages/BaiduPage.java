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

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public  String  url;
    public  String  input;
    public  String  submit;
    public  String  xpath;
    public  String className;
    public  String  xpath1;
    public String  xpath2;
    public String  xpath3;
    public  String  xpath4;



    public void search(String keyword){
        driver.get(url);
        driver.findElement(By.id(input)).sendKeys(keyword);
        driver.findElement(By.id(submit)).click();
        WebElement h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));//第一行搜索结果的标题
        String expected = h3.getText();
        if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");

    }


    public void searchAndFilter(String keyword,String startDate,String endDate){
        driver.get(url);
        driver.findElement(By.id(input)).sendKeys(keyword);
        driver.findElement(By.id(submit)).click();
        //搜索结果检查
        WebElement h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));//第一行搜索结果的标题
        String expected = h3.getText();
        if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");
        /**
         * 搜索筛选实现
         */
        driver.findElement(By.className(className)).click();
        WebElement search_tool_tf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
        search_tool_tf.click();
        WebElement startDateEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));
        WebElement endDateEle = driver.findElement(By.xpath(xpath3));
        //输入开始时间与结束时间
        startDateEle.clear();
        startDateEle.sendKeys(startDate);
        endDateEle.clear();
        endDateEle.sendKeys(endDate);
        //点击"确认"
        driver.findElement(By.linkText("确认")).click();

        //检查预期搜索结果
        WebElement h3ByFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath4)));//第一行搜索结果的标题
        String expectedFilter = h3ByFilter.getText();
        if (!expectedFilter.contains(keyword))
            throw new AssertionError("筛选后结果不符合预期");
    }

    }




