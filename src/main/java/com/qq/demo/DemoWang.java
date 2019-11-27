package com.qq.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWang {
    public static void main(String[] args) throws java.lang.InterruptedException{
        String chromePath = "C:\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.baidu.com");
        Thread.sleep(1000);
        driver.findElement(By.id("kw")).sendKeys("hello world");
        Thread.sleep(1000);
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000);

        String expected = driver.findElement(By.xpath("html/body/div/div/div/div/div/h3/a/em")).getText();
        if (expected.contains("hello world")) {
            System.out.println("第一条搜索结果中包含hello world");
        } else {
            System.out.println("第一条搜索结果中不包含hello world");
        }

        driver.quit();
    }
}