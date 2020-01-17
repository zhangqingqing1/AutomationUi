package com.qq.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BaiduPage  extends BasePage {

    public  String  input;
    public  String  submit;
    public  String  xpath;
    public  String className;
    public  String  xpath1;
    public  String  xpath2;
    public  String  xpath3;
    public  String  xpath4;

    public BaiduPage() {
        BasePage basePage=new BasePage("https://www.baidu.com/?tn=44004473_1_oem_dg");
    }


    public void search(String keyword){
        WebElement webElement=this.getDriver().findElement(By.id(input));
        sendkeys(webElement,keyword);
        click(By.id(submit));
        WebElement h3 = this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));//第一行搜索结果的标题
        String expected = h3.getText();
        if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");
    }


    public void searchAndFilter(String keyword,String startDate,String endDate){
       WebElement element=this.getDriver().findElement(By.id(input));
       sendkeys(element,keyword);
        //搜索结果检查
      WebElement h3 = this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));//第一行搜索结果的标题
      String expected = h3.getText();
      if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");
        /**
         * 搜索筛选实现
         */
        click(By.className(className));
        click(By.xpath(xpath1));
        WebElement startDateEle = this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));
        WebElement endDateEle = this.getDriver().findElement(By.xpath(xpath3));
        //输入开始时间与结束时间
        startDateEle.clear();
        startDateEle.sendKeys(startDate);
        endDateEle.clear();
        endDateEle.sendKeys(endDate);
        //点击"确认"
        this.getDriver().findElement(By.linkText("确认")).click();

        //检查预期搜索结果
        WebElement h3ByFilter = this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath4)));//第一行搜索结果的标题
        String expectedFilter = h3ByFilter.getText();
        if (!expectedFilter.contains(keyword))
            throw new AssertionError("筛选后结果不符合预期");
    }

    }




