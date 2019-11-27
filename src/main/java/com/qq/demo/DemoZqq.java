package com.qq.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoZqq {
    public static void main(String[] args) throws InterruptedException {
        //实现百度搜索   “hello world”功能，并且检查第一条搜索结果标题中，是否匹配到“hello world”
        //指定浏览器驱动路径
        System.setProperty ( "webdriver.chrome.driver", "D:\\driver\\chromedriver.exe" );
        //初始化浏览器名为driver
        WebDriver driver = new ChromeDriver ();
        //窗口最大化
        driver.manage ().window ().maximize ();
        //使用get()方法，打开百度网址
        driver.get ( "http://www.baidu.com" );
        driver.findElement(By.id("kw")).sendKeys("hello world");
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000);
        //判断网页标题是是否是"百度一下，你就知道"
        String expected = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a/em")).getText();
        if (expected.contains("hello world")) {
            System.out.println("第一条搜索结果中包含hello world");
        } else {
            System.out.println("第一条搜索结果中不包含hello world");
        }
        driver.quit();
    }



    }

