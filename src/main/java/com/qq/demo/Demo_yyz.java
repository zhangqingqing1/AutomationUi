package com.qq.demo;
import com.qq.util.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class Demo_yyz {
    private static WebDriver driver;
    public static void main(String[] args)throws InterruptedException, IOException{
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

        /*
        第二个任务：筛选当年1月1日到当天的信息，并检测第一条搜索结果
        */

        //点击搜索工具
        Thread.sleep(1000);
        driver.findElement(By.className("search_tool")).click();
        //点击时间不限
        Thread.sleep(1000);
        driver.findElement(By.className("search_tool_tf ")).click();
        //清除默认时间
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[2]/input")).clear();
        //输入时间内容
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[1]/input")).sendKeys(DateUtil.firstDayOfYear());
        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/p[2]/input")).sendKeys(DateUtil.currentDay());

        driver.findElement(By.xpath("//*[@id=\"c-tips-container\"]/div[1]/div/div/ul/li[6]/a")).click();

        //检测结果
        WebElement s1 = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a"));
        String search = s1.getText();
        if (search.contains(keyword)){
            System.out.println("筛选结果正确，符合预期");
        }else {
            System.out.println("筛选结果不符合预期");
        }

        driver.quit();
    }
}
