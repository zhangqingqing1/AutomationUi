package com.qq.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoYang{
    public static void main(String[] args) throws InterruptedException {
        //实现百度搜索   “hello world”功能，并且检查第一条搜索结果标题中，是否匹配到“hello world”

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jdk1.8.0_91\\chromedriver.exe");
        WebDriver driver;
        driver  = new ChromeDriver();
        //输入地址
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();

        //输入hello world并点击搜索
        driver.findElement(By.id("kw")).sendKeys("Hello World");
        driver.findElement(By.id("su")).click();

        //等待结果
        Thread.sleep(1000);

        //搜索结果第一行，查询其中包含内容
        String expected = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a[1]")).getText();

        //检查是否包含内容
        if (expected.contains("hello world")){
            System.out.println("包含Hello World");
        }else {
            System.out.println("不包含Hello World");
        }

        driver.quit();
    }
}
