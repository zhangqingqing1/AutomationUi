package com.qq.demo;

import com.qq.util.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

/**
 * @Desc
 * @Author qiwei.lu@b-and-qchina.com
 * @Date 2019/11/26 15:22
 */
public class Demo {
    //private static final String driverPath = Demo.class.getResource("/").getPath() + "drivers/chromedriver77.0.3865.90.exe";
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
        String keyword = "hello world";
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();

        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3 = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expected = h3.getText();
        if (expected.contains(keyword)) {
            System.out.println("搜索成功，符合预期");
        } else {
            System.out.println("搜索结果不符合预期");
        }

        /**
         * 搜索筛选实现
         */
        //点击"搜索工具"
        driver.findElement(By.className("search_tool")).click();
        //点击"时间不限"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='search_tool_tf ']")).click();
        Thread.sleep(500);
        WebElement startDateEle = driver.findElement(By.xpath("//*[@class=\"c-tip-custom-st\"]/input"));
        WebElement endDateEle = driver.findElement(By.xpath("//*[@class=\"c-tip-custom-et\"]/input"));
        //输入开始时间与结束时间
        startDateEle.clear();
        startDateEle.sendKeys(DateUtil.firstDayOfYear());
        endDateEle.clear();
        endDateEle.sendKeys(DateUtil.currentDay());
        //点击"确认"
        driver.findElement(By.linkText("确认")).click();

        //检查预期
        Thread.sleep(1000 * 3);//等待搜索结果
        //搜索结果
        WebElement h3ByFilter = driver.findElement(By.xpath("//*[@id='content_left']//h3"));//第一行搜索结果的标题
        //检查标题内容
        String expectedFilter = h3ByFilter.getText();
        if (expectedFilter.contains(keyword)) {
            System.out.println("筛选后搜索正确");
        } else {
            System.out.println("筛选后搜索结果不正确");
        }

        //关闭浏览器连接，释放资源
        driver.quit();
    }
}
