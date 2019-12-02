package com.qq.demo;

import com.qq.util.DateUtil;
import com.qq.util.DateUtilWang;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class Demo_wxj {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
        String userName = System.getProperty("user.name");
        Properties properties = new Properties();
        properties.load(Demo.class.getResourceAsStream("/chromeversion.properties"));
        String chromeVersion = properties.getProperty(userName);
        String driverPath = Demo.class.getResource("/").getPath() + "drivers/chromedriver" + chromeVersion + ".exe";

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //搜索hello world
        String keyword="hello world";
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000 * 3);

        //点击搜索工具
        driver.findElement(By.className("search_tool")).click();
        Thread.sleep(1000 * 3);
        //点击时间不限
        driver.findElement(By.className("search_tool_tf")).click();
        Thread.sleep(1000 * 3);
        //清空开始时间输入框 并获取当年第一天
        driver.findElement(By.name("st")).clear();
        Thread.sleep(1000 * 3);
        driver.findElement(By.name("st")).sendKeys(DateUtilWang.getFirstDayOfCurrentYear());
        Thread.sleep(1000 * 3);

        //清空结束时间输入框 并获取当年当天
        driver.findElement(By.name("et")).clear();
        Thread.sleep(1000 * 3);
        driver.findElement(By.name("et")).sendKeys(DateUtilWang.getCurrentDay());
        Thread.sleep(1000 * 3);
        //点击确定
        driver.findElement(By.className("c-tip-custom-submit")).click();

        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3ByFilter = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (expectedFilter.contains(keyword)) {
            System.out.println("筛选后搜索结果包含hello world");
        } else {
            System.out.println("筛选后搜索结果不包含hello world");
        }

        //关闭浏览器连接，释放资源
        driver.quit();
    }
}
