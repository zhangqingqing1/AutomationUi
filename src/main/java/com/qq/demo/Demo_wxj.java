package com.qq.demo;

import com.qq.util.DataProvider_wxj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class Demo_wxj {
    private static WebDriver driver;
    private static WebDriverWait wait;
    @BeforeTest
    public void beforeTest() throws IOException {
        String userName = System.getProperty("user.name");
        Properties properties = new Properties();
        properties.load(Demo_wxj.class.getResourceAsStream("/chromeversion.properties"));
        String chromeVersion = properties.getProperty(userName);
        String driverPath = Demo_wxj.class.getResource("/").getPath() + "drivers/chromedriver" + chromeVersion + ".exe";

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
    }

    @Test(dataProvider = "provider", dataProviderClass = DataProvider_wxj.class)
    public void searchTest(String keyword,String startTime,String endTime) throws InterruptedException{
        //搜索关键字
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //检查第一行搜索结果的标题
        WebElement h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));

        //检查标题内容
        String expected = h3.getText();
        if (!expected.contains(keyword)) throw new AssertionError("搜索结果第一行标题不包含关键字");

        /*搜索工具筛选*/
        //点击搜索工具
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search_tool"))).click();
        //点击时间不限
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search_tool_tf"))).click();
        //清空开始时间输入框 并获取开始时间
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("st"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("st"))).sendKeys(startTime);
        //清空结束时间输入框 并获取结束时间
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("et"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("et"))).sendKeys(endTime);
        //点击确定
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c-tip-custom-submit"))).click();

        //检查第一行搜索结果的标题
        WebElement h3ByFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content_left']//h3")));
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (!expectedFilter.contains(keyword))  throw new AssertionError("筛选结果不符合预期");
    }
    
    @AfterTest
    public void afterTest() {if(null != driver) driver.quit();}
}
